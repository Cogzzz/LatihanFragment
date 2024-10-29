package c14220127.paba_b.latihanfragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SettingsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SettingsFragment : Fragment() {
    private lateinit var radioGroup: RadioGroup
    private lateinit var saveButton: Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        radioGroup = view.findViewById(R.id.difficultyGroup)
        saveButton = view.findViewById(R.id.button_save)

        // inisiasi SharedPreferences untuk menyimpan pengaturan permainan
        sharedPreferences = requireActivity().getSharedPreferences("GameSettings", Context.MODE_PRIVATE)

        // Inisialisasi radio button berdasarkan pengaturan dan maximumk number untuk nilai mkasimum yang ditampilkan di gamefragment
        val savedMaxNumber = sharedPreferences.getInt("max_number", 5)
        when (savedMaxNumber) {
            3 -> radioGroup.check(R.id.jumlah3)
            5 -> radioGroup.check(R.id.jumlah5)
            7 -> radioGroup.check(R.id.jumlah7)
        }
        saveButton.setOnClickListener {
            saveMaxNumber()
        }
        return view
    }


    private fun saveMaxNumber() {
        val selected = radioGroup.checkedRadioButtonId
        val maxNumber = when (selected) {
            R.id.jumlah3 -> 3
            R.id.jumlah5 -> 5
            R.id.jumlah7 -> 7
            else -> 5
        }
        with(sharedPreferences.edit()) {
            putInt("max_number", maxNumber)
            apply()
        }
    }
}