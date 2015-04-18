package at.marklnet.spikes.android.firstspike;

import android.app.Activity;
import android.app.AlertDialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Simple first Spike to play around with Android.
 * 
 * Click Button with Event Handling. Increments a value in a TExtView and Progressbar.
 * 
 * Plays a mp3 Sound when clicking a Button.
 * 
 * @author marklm
 */
public class MainActivity extends Activity implements OnClickListener {
	
	private Button button;
	private Button playSoundButton;
	private TextView text;
	private ProgressBar progressBar;
	
	private  MediaPlayer mediaPlayer;
	
	private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.button = (Button) findViewById(R.id.clickButton);
        this.playSoundButton = (Button) findViewById(R.id.playSoundButton);
        this.text = (TextView) findViewById(R.id.clickText);
        this.progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        
        button.setOnClickListener(this);
        playSoundButton.setOnClickListener(this);
        
        // Testsound File at /res/raw
        mediaPlayer = MediaPlayer.create(this, R.raw.testsound);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

	@Override
	public void onClick(View v) {
		
		if (v == button) {
			System.out.println("Button clicked.....");
			counter ++;
			
			text.setText("Click Nummer: " + counter);
			
			progressBar.incrementProgressBy(10);
			
			if (counter == 10) {
				AlertDialog dialog = new AlertDialog.Builder(this).create();
				dialog.setMessage("Jetzt reicht's aber ;-)");
				dialog.show();
				counter = 0;
				
				progressBar.setProgress(0);
				
				text.setText("Click Nummer: " + counter);
			}
		}						
		
		if (v == playSoundButton) {
			
			try {
				mediaPlayer.start();
			} catch (Exception e) {
				System.err.println(e);
			}
			
		}
	}
	
	// Release Resources
	protected void onDestroy() {
		super.onDestroy();
		// if mediaplayer is still holding mediaplayer
		if (mediaPlayer != null) {
			// release the mediaplayer
			mediaPlayer.release();
			// Assign it with null value
			mediaPlayer = null;
		}
	}
}
