package c14220127.paba_b.latihanfragment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private var currentScore = 50

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup bottom navigation
        val bottomNav = findViewById<BottomNavigationView>(R.id.topNavigationView)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_game -> {
                    loadFragment(GameFragment())
                    true
                }
                R.id.action_result -> {
                    val fragment = ResultFragment()
                    val bundle = Bundle()
                    bundle.putInt("score", currentScore)
                    fragment.arguments = bundle
                    loadFragment(fragment)
                    true
                }
                R.id.action_settings -> {
                    loadFragment(SettingsFragment())
                    true
                }
                else -> false
            }
        }
        loadFragment(GameFragment())
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    fun updateScore(score: Int) {
        currentScore = score
    }
}