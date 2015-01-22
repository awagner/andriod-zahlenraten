package de.dillingen.zahlenraten;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


public class Zahlenraten extends ActionBarActivity {

    private int zahl;
    private int versuche = 0;

    private Random zufallsgenerator;

    // Referenzen auf die Viewobject
    private EditText inputnumber;
    private TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zahlenraten);

        zufallsgenerator = new Random();

        // Referenzen der ViewObjecte holen.
        prepareViewObjects();

        // Spiel starten.
        newGame();
    }

    /** holt die Referenzen auf die Viewobjekte */
    protected void prepareViewObjects() {
        inputnumber = (EditText) this.findViewById(R.id.inputnumber);
        status = (TextView) this.findViewById(R.id.status);
    }

    /** startet ein neues Spiel */
    public void newGame() {

        zahl = zufallsgenerator.nextInt(101);
        status.setText("Raten Sie eine Zahl zwischen 0 und 100!");
    }

    /** überprüft die eingegebene Zahl */
    private void checkNumber() {

        int currentnumber = Integer.parseInt(inputnumber.getText().toString());

        if (currentnumber == zahl) {
            status.setText("Sie haben die Zahl erraten!");
        } else {
            if (currentnumber < zahl) {
                status.setText("Die Zahl ist zu klein!");
            } else {
                status.setText("Die Zahl ist zu groß!");
            }
        }
        versuche++;

    }

    /** Ereignisbehandlung des "starteSpiel" Buttons: startet das Spiel */
    public void onClickNewGame(View v) {
        this.newGame();
    }

    /** Ereignisbehandlung des "Zahl überprüfen" Buttons */
    public void onClickCheckNumber(View v) {
        this.checkNumber();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_zahlenraten, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
