package cmps312.lab.bankingapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.navHostFragment)
        // Connect the drawerNavView to the NavController
        drawerNavView.setupWithNavController(navController)

        // Show Drawer button on the action bar for top level destinations
        // and the Nav Up button on child screens
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerlayout)
        setupActionBarWithNavController(navController, appBarConfiguration)


        navController.addOnDestinationChangedListener(::onDestinationChanged)// Remove the left caret
        supportActionBar?.setDisplayShowHomeEnabled(false);
    }

    //override fun onSupportNavigateUp() = navController.navigateUp()
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }


    override fun onResume() {
        super.onResume()
        navController.addOnDestinationChangedListener(::onDestinationChanged)
    }

    override fun onPause() {
        super.onPause()
        navController.removeOnDestinationChangedListener(::onDestinationChanged)
    }

    private fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        when (destination.id) {
            R.id.transferConfirmationFragment or R.id.transactionListFragment
            -> Toast.makeText(this, destination.label, Toast.LENGTH_SHORT).show()
        }
    }
}
