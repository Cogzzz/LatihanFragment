package c14220127.paba_b.latihanfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val score = arguments?.getInt("score", 0) ?: 0
        view.findViewById<TextView>(R.id.scoreResultText).text = "Final Score: $score"

        // Menampilkan pesan berdasarkan score
        val messageText = when {
            score >= 80 -> "Excellent!"
            score >= 60 -> "Good Job!"
            score >= 40 -> "Not Bad!"
            else -> "Try Again!"
        }
        view.findViewById<TextView>(R.id.messageText).text = messageText
    }
}