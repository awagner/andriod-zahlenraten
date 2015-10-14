package de.dillingen.zahlenraten;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Zahlenraten extends ActionBarActivity {

    private int zahl;
    private int versuche = 0;
    private Random zufallsgenerator;

    // Referenzen auf die Views
    private EditText inputnumber;
    private TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zahlenraten);

        zufallsgenerator = new Random();

        // Referenzen der Views holen.
        inputnumber = (EditText) this.findViewById(R.id.inputnumber);
        status = (TextView) this.findViewById(R.id.status);

        // Spiel starten.
        newGame();
    }

    /**
     * Startet ein neues Spiel
     */
    public void newGame() {

        zahl = zufallsgenerator.nextInt(101);
        status.setText("Raten Sie eine Zahl zwischen 0 und 100!");
    }

    /**
     * Überprüft die eingegebene Zahl
     */
    private void checkNumber() {

        // Die eingegebene Zahl auslesen.
        int currentnumber = Integer.parseInt(inputnumber.getText().toString());
        versuche++;

        if (currentnumber == zahl) {

            status.setText("Sie haben die Zahl erraten!\nVersuche: " + versuche);

        } else {

            if (currentnumber < zahl) {
                status.setText(currentnumber + " ist zu klein!\nVersuche: " + versuche);
                inputnumber.setText("");
            } else {
                status.setText(currentnumber + " ist zu groß!\nVersuche: " + versuche);
                inputnumber.setText("");
            }
        }
    }

    /**
     * Falls bei der Tastatureingabe die Enter-Taste gedrückt wird, die Nummer prüfen
     * und die Tastatur schließen (return true).
     *
     * @param keyCode, die Codierungszahl für die verschiedenen Tasten
     * @param event,   Zusatz-Parameter für den Event
     * @return true,   falls die Berechnung durchgeführt wurde und die Tastatur geschlossen
     * werden soll.
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            this.checkNumber();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    /**
     * Startet das Spiel (Ereignisbehandlung des "starteSpiel" Buttons)
     */
    public void onClickNewGame(View v) {
        this.newGame();
    }
}