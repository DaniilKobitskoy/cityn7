package app1.win.app1.win.sport1.win1.win.india1.xbet.win

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.GridView
import android.widget.Toast
import androidx.fragment.app.Fragment
import app1.win.app1.win.sport1.win1.win.india1.xbet.win.databinding.FragmentGamesportBinding


private var sport1w: GridView? = null
    private var adapt1W: adaptGame? = null


var POLEGAME: Int = 4
class gm1WinsAllMain : Fragment() {
    private var binding: FragmentGamesportBinding? = null
    private val binding1 get() = binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGamesportBinding.inflate(inflater, container, false)
        return binding1?.root
        binding1.back.setOnClickListener {
            _binding.cF.visibility = View.GONE
            _binding.t.visibility = View.VISIBLE
            _binding.b1.visibility = View.VISIBLE
            _binding.baaaaton2.visibility = View.VISIBLE
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sport1w = binding1.field as GridView
        sport1w!!.numColumns = POLEGAME
        sport1w!!.isEnabled = true

        adapt1W = adaptGame(requireContext(), POLEGAME, POLEGAME)
        sport1w!!.adapter = adapt1W

        sport1w!!.onItemClickListener =
            OnItemClickListener { parent, v, position, id ->
                adapt1W!!.checkedstatposition()
                adapt1W!!.positionOpen(position)
                if (adapt1W!!.gmovers()) Toast.makeText(
                    requireContext(),
                    "Игра закончена",
                    Toast.LENGTH_SHORT
                ).show()
            }
        binding1.back.setOnClickListener {
            _binding.t.visibility = View.VISIBLE
            _binding.b1.visibility = View.VISIBLE
            _binding.baaaaton2.visibility = View.VISIBLE
            _binding.cont2.visibility = View.GONE
            val fr = otveti1()

            val tr = requireFragmentManager().beginTransaction()

            tr.replace(
                _binding.cF.id,
                fr
            )

            tr.commit()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = gm1WinsAllMain()

    }
}