package ViewPager2

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.geekhub_android.csbc.fragments.*


class ExampleStateAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle, context: Context) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    var fragments:ArrayList<Fragment> = arrayListOf(
        FragmentMonday(context),
        FragmentTuesday(),
        FragmentWednesday(),
        FragmentThursday(),
        FragmentFriday(),
        FragmentSaturday()
    )
    override fun getItemCount(): Int {
       return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}