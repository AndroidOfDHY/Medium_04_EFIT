package com.org.efit.takephoto;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.dream.myqiyi.R;
import com.org.efit.util.HttpUtil;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.PictureCallback;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.R.bool;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class TakePhoto extends Activity  implements SurfaceHolder.Callback {
	private static final String tag="ccf";
	private boolean isZp=false;
    SurfaceHolder mHolder;   
    Camera mCamera=null;   
    Bitmap cameraBitmap;
    private SurfaceView mPreviewSV = null;
    private static final String path="/sdcard/tempPhoto";
    private static final String fileName="head.jpg";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
		Window myWindow = this.getWindow();
		myWindow.setFlags(flag, flag);     

       this. setContentView(R.layout.activity_takephone);
        Button takeButton=(Button) findViewById(R.id.take);
        Button upButton=(Button) findViewById(R.id.up);
        mPreviewSV=  (SurfaceView)findViewById(R.id.previewSV);
        mHolder=mPreviewSV.getHolder();
        mHolder.addCallback(this);      
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        takeButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Log.i(tag, "onClick");
				takePicture();
			}
		});
        
        upButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				File myCaptureFile = new File(path+"/"+fileName); 
				try {
					String reslut=HttpUtil.upload(getResources().getString(R.string.url)+"user/user.do?act=upLaod",myCaptureFile);
					if(reslut.equals("0")||reslut.length()>100){
						popTip("上传失败");
					}
					else{
						popTip("上传成功");
						Intent intent = getIntent(); 
						intent.putExtra("image", reslut);
						setResult(0, intent); 
						 finish();
					}
				} catch (ClientProtocolException e) {
					e.printStackTrace();
					popTip("上传失败");
				} catch (IOException e) {
					e.printStackTrace();
					popTip("上传失败");
				}
					if (myCaptureFile!=null&&myCaptureFile.exists()) {
						myCaptureFile.delete();
					}
			}
		});
    }
    

	@Override
	public void onBackPressed() {
		setResult(0, null); 
		finish();
		super.onBackPressed();
	}

	public void popTip(String paramString)
    {
      Toast.makeText(this, paramString, 1).show();
    }


	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		Log.i(tag, "surfaceChanged");
		if(mCamera!=null){
        Camera.Parameters parameters = mCamera.getParameters();   
        parameters.setPictureFormat(PixelFormat.JPEG);       
       // parameters.setPictureSize(800, 600); 
       // parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_VIDEO);
        mCamera.setDisplayOrientation(90);  
        
        mCamera.setParameters(parameters);
        mCamera.startPreview();
        }
		else Log.i(tag, "mCamera is null");
		
	}


	public void surfaceCreated(SurfaceHolder holder) {
		Log.i(tag, "surfaceCreated");

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
			   for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
			    CameraInfo info = new CameraInfo();
			    Camera.getCameraInfo(i, info);
			    if (info.facing == CameraInfo.CAMERA_FACING_FRONT) {//前置摄像头
			    	mCamera = Camera.open(i);
			    	  isZp=true;
			    }
					
			   }
			 
			  }
		if (mCamera==null) {
			mCamera = Camera.open();
		}
	//	mCamera = Camera.open();
        try {           
        	mCamera.setPreviewDisplay(holder);   
        	}     
        catch (IOException e) {       
        	mCamera.release();      
        	mCamera = null;     
        	}
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		Log.i(tag, "surfaceDestroyed");
        mCamera.stopPreview();   
        mCamera.release();   
        mCamera = null;
	}

    public void takePicture() {        
    	if(mCamera != null) {  
    		Log.i(tag, "takePicture");
    		mCamera.takePicture(null, null, jpegCallback);    
    		}    
    	}  

    private PictureCallback jpegCallback = new PictureCallback() {
    	public void onPictureTaken(byte[] data, Camera arg1) {
   		Log.i(tag, "jpegCallback");
   		if (!Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState() )) {
			return;
		}
            cameraBitmap = BitmapFactory.decodeByteArray(data, 0, data.length);   
            File photoPath = new File(path);
            if (!photoPath.exists()) {
				photoPath.mkdir();
			}
            File myCaptureFile = new File(path+"/"+fileName);     
            try {            
            	BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(myCaptureFile)); 
            	if(!isZp){
            	rotate(cameraBitmap, 90).compress(Bitmap.CompressFormat.JPEG, 100, bos); 
            	}
            	else rotate(cameraBitmap, -90).compress(Bitmap.CompressFormat.JPEG, 100, bos);
            	bos.flush();             
            	bos.close();        
            	cameraBitmap.recycle();   
            	}        
            catch (Exception e) {          
            	e.getStackTrace();    
            	}
    	};
    };
    public static Bitmap rotate(Bitmap b, int degrees) {

        if (degrees != 0 && b != null) {

            Matrix m = new Matrix();
            
            m.setRotate(degrees,(float) b.getWidth() / 2, (float) b.getHeight() / 2);
            Log.i("w h", b.getWidth()+","+b.getHeight());
            m.postScale(0.7f,0.50625f); 
            try {

                Bitmap b2 = Bitmap.createBitmap(

                        b, 0, 0, b.getWidth(), b.getHeight(), m, true);

                if (b != b2) {

                    b.recycle();  

                    b = b2;

                }

            } catch (OutOfMemoryError ex) {
            }

        }

        return b;

    }

}
