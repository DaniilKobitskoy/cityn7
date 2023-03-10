package app1.win.app1.win.sport1.win1.win.india1.xbet.win
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import app1.win.app1.win.sport1.win1.win.india1.xbet.win.databinding.Otveti1Binding


class otveti1 : Fragment() {
    private var binding: Otveti1Binding? = null
    private val binding2 get() = binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Otveti1Binding.inflate(inflater, container, false)
        return binding2?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding2.b7.setOnClickListener {
            val f = otveti2()
            val t = requireFragmentManager().beginTransaction()
            t.replace(
               _binding.cF.id,
                f
            )
            t.commit()
        }
        binding2.iV.setOnClickListener {
            _binding.t.visibility = View.VISIBLE
            _binding.b1.visibility = View.VISIBLE
            _binding.baaaaton2.visibility = View.VISIBLE
            _binding.cF.visibility = View.GONE
        }
        binding2.cifilis4.setOnClickListener {
            summary ++
            Toast.makeText(requireContext(), "Go Next", Toast.LENGTH_SHORT).show()
            binding2.cifilis4.isClickable = false
            binding2.sifac.isClickable = false
            binding2.xyi.isClickable = false
            binding2.chlen.isClickable = false

        }
        binding2.sifac.setOnClickListener {
            Toast.makeText(requireContext(), "Go Next", Toast.LENGTH_SHORT).show()
            binding2.cifilis4.isClickable = false
            binding2.sifac.isClickable = false
            binding2.xyi.isClickable = false
            binding2.chlen.isClickable = false

        }
        binding2.xyi.setOnClickListener {
            Toast.makeText(requireContext(), "Go Next", Toast.LENGTH_SHORT).show()
            binding2.cifilis4.isClickable = false
            binding2.sifac.isClickable = false
            binding2.xyi.isClickable = false
            binding2.chlen.isClickable = false

        }
        binding2.chlen.setOnClickListener {
            Toast.makeText(requireContext(), "Go Next", Toast.LENGTH_SHORT).show()
            binding2.cifilis4.isClickable = false
            binding2.sifac.isClickable = false
            binding2.xyi.isClickable = false
            binding2.chlen.isClickable = false

        }
    }

    companion object {

        fun newInstance() = otveti1()

    }
}