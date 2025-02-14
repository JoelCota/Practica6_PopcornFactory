package lopez.joel.popcornfactory

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetallePelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        // Referencias a los elementos del layout
        val ivPelicula: ImageView = findViewById(R.id.iv_pelicula)
        val tvTitulo: TextView = findViewById(R.id.tv_nombre_pelicula)
        val tvDescripcion: TextView = findViewById(R.id.tv_pelicula_desc)

        // Obtener datos del intent
        val titulo = intent.getStringExtra("titulo")
        val imagen = intent.getIntExtra("image", 0)
        val header = intent.getIntExtra("header", 0)
        val sinopsis = intent.getStringExtra("sinopsis")

        // Asignar valores a los elementos de la UI
        tvTitulo.text = titulo
        ivPelicula.setImageResource(header)
        tvDescripcion.text = sinopsis
    }
}