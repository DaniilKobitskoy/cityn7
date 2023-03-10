package app1.win.app1.win.sport1.win1.win.india1.xbet.win
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import app1.win.app1.win.sport1.win1.win.india1.xbet.win.databinding.Otveti2Binding


class otveti2 : Fragment() {
    private var binding: Otveti2Binding? = null
    private val binding3 get() = binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Otveti2Binding.inflate(inflater, container, false)
        return binding3?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding3.b7.setOnClickListener {

            val fragment = otveti3()

            val transaction = requireFragmentManager().beginTransaction()

            transaction.replace(
                _binding.cF.id,
                fragment
            )

            transaction.addToBackStack(null)


            transaction.commit()
        }
        binding3.iV.setOnClickListener {
            val fragment = otveti1()

            val transaction = requireFragmentManager().beginTransaction()

            transaction.replace(
                _binding.cF.id,
                fragment
            )

            transaction.commit()
        }
        binding3.cifilis4.setOnClickListener {
            Toast.makeText(requireContext(), "comprehensive to the next question", Toast.LENGTH_SHORT).show()
            binding3.cifilis4.isClickable = false
            binding3.sifac.isClickable = false
            binding3.xyi.isClickable = false
            binding3.chlen.isClickable = false

        }
        binding3.sifac.setOnClickListener {
            summary ++
            Toast.makeText(requireContext(), "comprehensive to the next question", Toast.LENGTH_SHORT).show()
            binding3.cifilis4.isClickable = false
            binding3.sifac.isClickable = false
            binding3.xyi.isClickable = false
            binding3.chlen.isClickable = false

        }
        binding3.xyi.setOnClickListener {
            Toast.makeText(requireContext(), "comprehensive to the next question", Toast.LENGTH_SHORT).show()
            binding3.cifilis4.isClickable = false
            binding3.sifac.isClickable = false
            binding3.xyi.isClickable = false
            binding3.chlen.isClickable = false

        }
        binding3.chlen.setOnClickListener {
            Toast.makeText(requireContext(), "comprehensive to the next question", Toast.LENGTH_SHORT).show()
            binding3.cifilis4.isClickable = false
            binding3.sifac.isClickable = false
            binding3.xyi.isClickable = false
            binding3.chlen.isClickable = false

        }
    }
    companion object {

        fun newInstance() = otveti2()

    }
}