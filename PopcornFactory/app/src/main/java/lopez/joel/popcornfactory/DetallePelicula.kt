package lopez.joel.popcornfactory

import android.content.Intent
import android.os.Bundle
import android.widget.Button
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

        val bundle = intent.extras
        var ns = 0
        var id = -1

        var tituloPelicula = ""

        if (bundle != null) {
            ns = bundle.getInt("numberSeats")

            var title: TextView = findViewById(R.id.tituloPelicula) as TextView
            var description: TextView = findViewById(R.id.descripcionPelicula) as TextView
            var image: ImageView = findViewById(R.id.imagenPelicula) as ImageView
            var seatsLeft: TextView = findViewById(R.id.seatsLeft) as TextView

            tituloPelicula = intent.getStringExtra("titulo")!!
            var descripcionPelicula = intent.getStringExtra("sinopsis")!!
            var imagenPelicula = intent.getIntExtra("header", 0)!!
            var asientosRestantes = intent.getIntExtra("numberSeats", 0)!!
            id = intent.getIntExtra("pos", -1)

            title.setText(tituloPelicula)
            description.setText(descripcionPelicula)
            image.setImageResource(imagenPelicula)
            seatsLeft.setText("$asientosRestantes seats available ")
        }

        var buyTickets: Button = findViewById(R.id.buyTickets) as Button

        if (ns == 0) {
            buyTickets.isEnabled = false
        } else {
            buyTickets.isEnabled = true

            buyTickets.setOnClickListener {
                val intent: Intent = Intent(this, SeatSelection::class.java)
                intent.putExtra("movie", id)
                intent.putExtra("name", tituloPelicula)

                this.startActivity(intent)
            }
        }
    }
}