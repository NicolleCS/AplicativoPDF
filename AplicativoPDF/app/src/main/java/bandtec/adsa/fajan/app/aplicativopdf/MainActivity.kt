package bandtec.adsa.fajan.app.aplicativopdf

import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(v: View){
        val container = findViewById<LinearLayout>(R.id.ll_container);

        val list = LinearLayout(this)

        val editQuantity = EditText(this);
        val editDescription = EditText(this);
        val editValue = EditText(this)

        editQuantity.setHint("Digite a quantidade");
        editDescription.setHint("Digite a descrição");
        editValue.setHint("Digite o valor");

        list.gravity = Gravity.HORIZONTAL_GRAVITY_MASK
        list.orientation = GradientDrawable.Orientation.

        list?.addView(editQuantity);
        list?.addView(editDescription);
        list?.addView(editValue);

        container.addView(list);

    }
}