package com.ejercicio.ejercicio_2_calculadora;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class actividad_principal extends AppCompatActivity {

    /*Creamos los objetos de tipo Button para poder conectarlos a las vistas*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.actividad_principal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /*Conectar los objetos de tipo boton con las vistas mediante su ID */
        EditText input1 = findViewById(R.id.valor_1);
        EditText input2 = findViewById(R.id.valor_2);
        TextView text_resultado = findViewById(R.id.resultado);
        Button btn_Suma = findViewById(R.id.btn_Suma);
        Button btn_Resta = findViewById(R.id.btn_Resta);
        Button btn_Division = findViewById(R.id.btn_Division);
        Button btn_Multiplicacion = findViewById(R.id.btn_Multiplicacion);
        Button btn_Modulo = findViewById(R.id.btn_Modulo);
        Button btn_Limpiar = findViewById(R.id.btn_Limpiar);


        // Evento de clic para botón sumar
        btn_Suma.setOnClickListener(v -> {
            String input_1 = input1.getText().toString();
            String input_2 = input2.getText().toString();

            if (input_1.isEmpty() || input_2.isEmpty()) {
                Toast.makeText(this, "Completá ambos campos", Toast.LENGTH_SHORT).show();
                return;
            }

            // Manejo de excepciones
            try {
                double num1 = Double.parseDouble(input_1);
                double num2 = Double.parseDouble(input_2);

                double resultado_suma = num1 + num2;

                text_resultado.setText(String.format("%s", resultado_suma % 1 == 0 ? String.valueOf((long) resultado_suma) : String.format("%.2f", resultado_suma)));

            } catch (NumberFormatException e) {
                Toast.makeText(this, "Ingresá números válidos", Toast.LENGTH_SHORT).show();
            }
        });

        // Evento de clic para botón restar
        btn_Resta.setOnClickListener(v -> {
            String input_1 = input1.getText().toString();
            String input_2 = input2.getText().toString();

            if (input_1.isEmpty() || input_2.isEmpty()) {
                Toast.makeText(this, "Completá ambos campos", Toast.LENGTH_SHORT).show();
                return;
            }

            try {

                double num1 = Double.parseDouble(input_1);
                double num2 = Double.parseDouble(input_2);

                double resultado_resta = num1 - num2;

                text_resultado.setText(String.format("%s", resultado_resta % 1 == 0 ? String.valueOf((long) resultado_resta) : String.format("%.2f", resultado_resta)));

            } catch (NumberFormatException e) {
                Toast.makeText(this, "Ingresá números válidos", Toast.LENGTH_SHORT).show();
            }

        });

        // Evento de clic para botón división
        btn_Division.setOnClickListener(v -> {
            String input_1 = input1.getText().toString();
            String input_2 = input2.getText().toString();

            if (input_1.isEmpty() || input_2.isEmpty()) {
                Toast.makeText(this, "Completá ambos campos", Toast.LENGTH_SHORT).show();
                return;
            }

            // Manejo de excepciones
            try {
                double num1 = Double.parseDouble(input_1);
                double num2 = Double.parseDouble(input_2);
                if (num2 == 0) {
                    text_resultado.setText("Error: no es posible");
                    return;
                }

                double resultado_division = num1 / num2;

                text_resultado.setText(String.format("%s", resultado_division % 1 == 0 ? String.valueOf((long) resultado_division) : String.format("%.2f", resultado_division)));

            } catch (NumberFormatException e) {
                Toast.makeText(this, "Ingresá números válidos", Toast.LENGTH_SHORT).show();
            }


        });

        // Evento de clic para botón multiplicación
        btn_Multiplicacion.setOnClickListener(v -> {
            String input_1 = input1.getText().toString();
            String input_2 = input2.getText().toString();

            if (input_1.isEmpty() || input_2.isEmpty()) {
                Toast.makeText(this, "Completá ambos campos", Toast.LENGTH_SHORT).show();
                return;
            }

            // Manejo de excepciones
            try {

                double num1 = Double.parseDouble(input_1);
                double num2 = Double.parseDouble(input_2);

                double resultado_multiplicar = num1 * num2;

                text_resultado.setText(String.format("%s", resultado_multiplicar % 1 == 0 ? String.valueOf((long) resultado_multiplicar) : String.format("%.2f", resultado_multiplicar)));

            } catch (NumberFormatException e) {
                Toast.makeText(this, "Ingresá números válidos", Toast.LENGTH_SHORT).show();
            }
        });

        // Evento de clic para botón limpiar
        btn_Limpiar.setOnClickListener(v -> {

            input1.setText("");
            input2.setText("");
            text_resultado.setText("");

            Toast.makeText(this, "Pantalla limpiada", Toast.LENGTH_SHORT).show();

        });

        // Evento de clic para botón módulo
        btn_Modulo.setOnClickListener(v -> {

            String input_1 = input1.getText().toString();
            String input_2 = input2.getText().toString();

            if (input_1.isEmpty() || input_2.isEmpty()) {
                Toast.makeText(this, "Completá ambos campos", Toast.LENGTH_SHORT).show();
                return;
            }

            // Manejo de excepciones
            try {

                int num1 = Integer.parseInt(input_1);
                int num2 = Integer.parseInt(input_2);

                if (num2 == 0) {
                    text_resultado.setText("Error: división por cero");
                    return;
                }

                int resultado_modulo = num1 % num2;

                text_resultado.setText(String.valueOf(resultado_modulo));

            } catch (NumberFormatException e) {

                Toast.makeText(this,
                        "El módulo requiere números enteros",
                        Toast.LENGTH_SHORT).show();
            }

        });

    }
}