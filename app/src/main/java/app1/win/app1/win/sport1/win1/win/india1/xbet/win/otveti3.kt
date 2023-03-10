package app1.win.app1.win.sport1.win1.win.india1.xbet.win
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import app1.win.app1.win.sport1.win1.win.india1.xbet.win.databinding.Otveti3Binding


class otveti3 : Fragment() {
    private var binding: Otveti3Binding? = null
    private val binding4 get() = binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Otveti3Binding.inflate(inflater, container, false)
        return binding4?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding4.b7.setOnClickListener {
            val fragment = otveti4()

            val transaction = requireFragmentManager().beginTransaction()

            transaction.replace(
                _binding.cF.id,
                fragment
            )

            transaction.commit()

        }
        binding4.iV.setOnClickListener {
            val fragment = otveti2()

            val transaction = requireFragmentManager().beginTransaction()

            transaction.replace(
                _binding.cF.id,
                fragment
            )

            transaction.commit()
        }
        binding4.cifilis4.setOnClickListener {
            Toast.makeText(requireContext(), "comprehensive to the next question", Toast.LENGTH_SHORT).show()
            binding4.cifilis4.isClickable = false
            binding4.sifac.isClickable = false
            binding4.xyi.isClickable = false
            binding4.chlen.isClickable = false

        }
        binding4.sifac.setOnClickListener {
            Toast.makeText(requireContext(), "comprehensive to the next question", Toast.LENGTH_SHORT).show()
            binding4.cifilis4.isClickable = false
            binding4.sifac.isClickable = false
            binding4.xyi.isClickable = false
            binding4.chlen.isClickable = false

        }
        binding4.xyi.setOnClickListener {
            Toast.makeText(requireContext(), "comprehensive to the next question", Toast.LENGTH_SHORT).show()
            binding4.cifilis4.isClickable = false
            binding4.sifac.isClickable = false
            binding4.xyi.isClickable = false
            binding4.chlen.isClickable = false

        }
        binding4.chlen.setOnClickListener {
            summary ++
            Toast.makeText(requireContext(), "comprehensive to the next question", Toast.LENGTH_SHORT).show()
            binding4.cifilis4.isClickable = false
            binding4.sifac.isClickable = false
            binding4.xyi.isClickable = false
            binding4.chlen.isClickable = false

        }
    }
    companion object {

        fun newInstance() = otveti3()

    }
}