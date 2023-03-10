package app1.win.app1.win.sport1.win1.win.india1.xbet.win
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import app1.win.app1.win.sport1.win1.win.india1.xbet.win.databinding.Otveti4Binding


class otveti4 : Fragment() {
    private var binding: Otveti4Binding? = null
    private val binding5 get() = binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Otveti4Binding.inflate(inflater, container, false)
        return binding5?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding5.iV.setOnClickListener {
            val fragment = otveti3()

            val transaction = requireFragmentManager().beginTransaction()

            transaction.replace(
                _binding.cF.id,
                fragment
            )

            transaction.commit()
        }
        binding5.cifilis4.setOnClickListener {
            Toast.makeText(requireContext(), "comprehensive to the next question", Toast.LENGTH_SHORT).show()
            binding5.cifilis4.isClickable = false
            binding5.sifac.isClickable = false
            binding5.xyi.isClickable = false
            binding5.chlen.isClickable = false

        }
        binding5.sifac.setOnClickListener {
            Toast.makeText(requireContext(), "comprehensive to the next question", Toast.LENGTH_SHORT).show()
            binding5.cifilis4.isClickable = false
            binding5.sifac.isClickable = false
            binding5.xyi.isClickable = false
            binding5.chlen.isClickable = false

        }
        binding5.xyi.setOnClickListener {
            summary ++
            Toast.makeText(requireContext(), "comprehensive to the next question", Toast.LENGTH_SHORT).show()
            binding5.cifilis4.isClickable = false
            binding5.sifac.isClickable = false
            binding5.xyi.isClickable = false
            binding5.chlen.isClickable = false

        }
        binding5.chlen.setOnClickListener {
            Toast.makeText(requireContext(), "comprehensive to the next question", Toast.LENGTH_SHORT).show()
            binding5.cifilis4.isClickable = false
            binding5.sifac.isClickable = false
            binding5.xyi.isClickable = false
            binding5.chlen.isClickable = false

        }
        binding5.b7.setOnClickListener {
            val fragment = otveti5()

            val transaction = requireFragmentManager().beginTransaction()

            transaction.replace(
                _binding.cF.id,
                fragment
            )

            transaction.commit()
        }
    }
    companion object {

        fun newInstance() = otveti4()
    }
}