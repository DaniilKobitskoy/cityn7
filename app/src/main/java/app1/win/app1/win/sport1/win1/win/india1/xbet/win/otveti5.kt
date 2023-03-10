package app1.win.app1.win.sport1.win1.win.india1.xbet.win
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import app1.win.app1.win.sport1.win1.win.india1.xbet.win.databinding.Otveti5Binding


class otveti5 : Fragment() {
    private var binding: Otveti5Binding? = null
    private val binding6 get() = binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Otveti5Binding.inflate(inflater, container, false)
        return binding6?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding6.cifilis4.setOnClickListener {
            summary ++
            binding6.summ.setText("You answered the question \n${summary.toString()} correctly")
            binding6.summ.visibility = View.VISIBLE
            Toast.makeText(requireContext(), "comprehensive to the next question", Toast.LENGTH_SHORT).show()
            binding6.cifilis4.isClickable = false
            binding6.sifac.isClickable = false
            binding6.xyi.isClickable = false
            binding6.chlen.isClickable = false

        }
        binding6.sifac.setOnClickListener {
            binding6.summ.setText("Вы ответили правильно на ${summary.toString()} вопросов")
            binding6.summ.visibility = View.VISIBLE
            Toast.makeText(requireContext(), "comprehensive to the next question", Toast.LENGTH_SHORT).show()
            binding6.cifilis4.isClickable = false
            binding6.sifac.isClickable = false
            binding6.xyi.isClickable = false
            binding6.chlen.isClickable = false
            binding6.summ.setText("Вы ответили правильно на ${summary.toString()} вопросов")
            binding6.summ.visibility = View.VISIBLE

        }
        binding6.xyi.setOnClickListener {
            Toast.makeText(requireContext(), "comprehensive to the next question", Toast.LENGTH_SHORT).show()
            binding6.cifilis4.isClickable = false
            binding6.sifac.isClickable = false
            binding6.xyi.isClickable = false
            binding6.chlen.isClickable = false
            binding6.summ.setText("Вы ответили правильно на ${summary.toString()} вопросов")
            binding6.summ.visibility = View.VISIBLE
        }
        binding6.chlen.setOnClickListener {
            Toast.makeText(requireContext(), "comprehensive to the next question", Toast.LENGTH_SHORT).show()
            binding6.cifilis4.isClickable = false
            binding6.sifac.isClickable = false
            binding6.xyi.isClickable = false
            binding6.chlen.isClickable = false
            binding6.summ.setText("Вы ответили правильно на ${summary.toString()} вопросов")
            binding6.summ.visibility = View.VISIBLE


        }
        binding6.b7.setOnClickListener {
            _binding.t.visibility = View.VISIBLE
            _binding.b1.visibility = View.VISIBLE
            _binding.baaaaton2.visibility = View.VISIBLE
            _binding.cF.visibility = View.GONE


        }

    }
    companion object {

        fun newInstance() = otveti5()
    }
}