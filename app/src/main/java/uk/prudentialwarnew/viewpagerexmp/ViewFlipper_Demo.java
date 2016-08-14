package uk.prudentialwarnew.viewpagerexmp;

/**
 * Created by user on 8/14/2016.
 */
import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;

import uk.prudentialwarnew.R;

public class ViewFlipper_Demo extends Activity {

    ImageSwitcher Switch;
    ImageView images;
    float initialX;
    private Cursor cursor;
    private  int columnIndex, position = 0;
    int imagePosition =0;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewflipper);
//        Switch = (ImageSwitcher) findViewById(R.id.imageSwitcher);
//        images = (ImageView) findViewById(R.id.imageView1);
//        int[] screens = {R.drawable.card1,R.drawable.card2};
//        String[] projection = {MediaStore.Images.Thumbnails._ID};
//        cursor = managedQuery(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, projection, null, null, MediaStore.Images.Thumbnails._ID + "");
//        columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Thumbnails._ID);

        final GestureDetector gdt = new GestureDetector(new GestureListener());
         imageView  = (ImageView) findViewById(R.id.imageView1);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.card1));
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(final View view, final MotionEvent event) {
                gdt.onTouchEvent(event);
                return true;
            }
        });
    }

    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                initialX = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                float finalX = event.getX();
                if (initialX > finalX)
                {
                    cursor.moveToPosition(position);
                    int imageID = cursor.getInt(columnIndex);
                    images.setImageURI(Uri.withAppendedPath(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, "" + imageID));
                    //images.setBackgroundResource(R.drawable.mb__messagebar_divider);
                    Switch.showNext();
                    Toast.makeText(getApplicationContext(), "Next Image",
                            Toast.LENGTH_LONG).show();
                    position++;
                }
                else
                {
                    if(position > 0)
                    {
                        cursor.moveToPosition(position);
                        int imageID = cursor.getInt(columnIndex);
                        images.setImageURI(Uri.withAppendedPath(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, "" + imageID));
                        //images.setBackgroundResource(R.drawable.ic_launcher);
                        Toast.makeText(getApplicationContext(), "previous Image",
                                Toast.LENGTH_LONG).show();
                        Switch.showPrevious();
                        position= position-1;
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "No More Images To Swipe",
                                Toast.LENGTH_LONG).show();
                    }
                }
                break;
        }
        return false;
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if(e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                if(imagePosition<6)
                imagePosition = imagePosition +1;
                setImage();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_in_right);


                return false; // Right to left
            }  else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                if(imagePosition>0)
                    imagePosition = imagePosition -1;
                setImage();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_in_left);
                return false; // Left to right
            }

            if(e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
                return false; // Bottom to top
            }  else if (e2.getY() - e1.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
                return false; // Top to bottom
            }
            return false;
        }
    }

    public void setImage(){
        if(imagePosition==0){
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.card1));
        }
        else if(imagePosition==1){
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.card2));
        }
        else if(imagePosition==2){
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.card3));
        }
        else if(imagePosition==3){
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.card4));
        }
        else if(imagePosition==4){
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.card5));
        }
        else if(imagePosition==5){
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.card6));
        }
        else {
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.card6));
        }
    }
}
