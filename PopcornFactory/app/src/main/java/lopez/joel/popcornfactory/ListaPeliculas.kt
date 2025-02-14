package lopez.joel.popcornfactory

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ListaPeliculas : AppCompatActivity() {

    var peliculas = ArrayList<Pelicula>()
    var series = ArrayList<Pelicula>()
    var adapterPeliculas: PeliculaAdapter? = null
    var adapterSeries: PeliculaAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_peliculas)

        cargarPeliculas()
        cargarSeries()

        val gridviewPeliculas: GridView = findViewById(R.id.gridview_movies)
        val gridviewSeries: GridView = findViewById(R.id.gridview_series)

        adapterPeliculas = PeliculaAdapter(this, peliculas)
        adapterSeries = PeliculaAdapter(this, series)

        gridviewPeliculas.adapter = adapterPeliculas
        gridviewSeries.adapter = adapterSeries
    }

    private fun cargarPeliculas() {
        peliculas.add(
            Pelicula(
                "Big Hero 6",
                R.drawable.bighero6,
                R.drawable.headerbighero6,
                "When a devastating event befalls the city of San Fransokyo and catapults Hiro into the " +
                        "midst of danger, he turns to Baymax and his close friends..."
            )
        )
        peliculas.add(
            Pelicula(
                "1917",
                R.drawable.milnovecientosdiezsiete,
                R.drawable.milnovecientosdiezsieteheader,
                "British trenches somewhere in France. World war has been going on for the third year..."
            )
        )
        peliculas.add(
            Pelicula(
                "Leap Year",
                R.drawable.leapyear,
                R.drawable.leapyearheader,
                "A woman who has an elaborate scheme to propose to her boyfriend on Leap Day..."
            )
        )
        peliculas.add(
            Pelicula(
                "Men in Black",
                R.drawable.mib,
                R.drawable.mibheader,
                "Based off of the comic book. Unbeknownst to other people, there is a private agency..."
            )
        )
        peliculas.add(
            Pelicula(
                "Toy Story",
                R.drawable.toystory,
                R.drawable.toystoryheader,
                "Toy Story is about the 'secret life of toys' when people are not around..."
            )
        )
        peliculas.add(
            Pelicula(
                "Inception",
                R.drawable.inception,
                R.drawable.inceptionheader,
                "Dom Cobb is a skilled thief, the absolute best in the dangerous art of extraction..."
            )
        )
    }

    private fun cargarSeries() {
        series.add(
            Pelicula(
                "Dr. House",
                R.drawable.drhouse,
                R.drawable.househeader,
                "The series follows the life of anti-social, pain killer addict, witty and arrogant medical doctor Gregory House..."
            )
        )
        series.add(
            Pelicula(
                "Smallville",
                R.drawable.smallville,
                R.drawable.smallvilleheader,
                "The numerous miraculous rescues by the local wonder boy Clark have aroused suspicions..."
            )
        )
        series.add(
            Pelicula(
                "Dr. Who",
                R.drawable.drwho,
                R.drawable.drwhoheader,
                "Traveling across time and space, the immortal time-lord known as 'The Doctor'..."
            )
        )
        series.add(
            Pelicula(
                "Bones",
                R.drawable.bones,
                R.drawable.bonesheader,
                "Dr. Temperance Brennan is a brilliant, but lonely, anthropologist..."
            )
        )
        series.add(
            Pelicula(
                "Suits",
                R.drawable.suits,
                R.drawable.suitsheader,
                "While running from a drug deal gone bad, brilliant young college dropout Mike Ross..."
            )
        )
        series.add(
            Pelicula(
                "Friends",
                R.drawable.friends,
                R.drawable.friendsheader,
                "Rachel Green, Ross Geller, Monica Geller, Joey Tribbiani, Chandler Bing and Phoebe Buffay..."
            )
        )
    }

    class PeliculaAdapter(val context: Context, val peliculas: ArrayList<Pelicula>) : BaseAdapter() {
        override fun getCount(): Int {
            return peliculas.size
        }

        override fun getItem(position: Int): Any {
            return peliculas[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val pelicula = peliculas[position]
            val inflater = LayoutInflater.from(context)
            val view = inflater.inflate(R.layout.pelicula, null)

            val imagen = view.findViewById<ImageView>(R.id.iv_pelicula)
            val titulo = view.findViewById<TextView>(R.id.tv_nombre_pelicula)

            imagen.setImageResource(pelicula.imagen)
            titulo.text = pelicula.titulo

            imagen.setOnClickListener {
                val intent = Intent(context, DetallePelicula::class.java)
                intent.putExtra("titulo", pelicula.titulo)
                intent.putExtra("image", pelicula.header)
                intent.putExtra("header", pelicula.header)
                intent.putExtra("sinopsis", pelicula.sinopsis)
                context.startActivity(intent)
            }

            return view
        }
    }
}
