package elite.polito.it.activity_lifecycle_demo;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;


public class LifecycleDemoActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle_demo);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        this.notify("onPause");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        this.notify("onResume");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        this.notify("onStop");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        this.notify("onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        this.notify("onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        this.notify("onRestoreInstanceState");
    }

    private void notify(String methodName)
    {
        //get the current class name
        String className = this.getClass().getSimpleName();

        //build the notification object
        Notification notification = new Notification.Builder(this).
                setContentTitle(methodName+" "+className).setAutoCancel(true).
                setSmallIcon(R.mipmap.ic_launcher).
                setContentText(className).build();

        //get the notification manager
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        //send the notification
        notificationManager.notify((int) System.currentTimeMillis(), notification);
    }
}
