package com.enet.sab.ui.view.home

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.enet.sab.R
import com.enet.sab.ui.theme.AtiselTheme
import com.enet.sab.ui.view.user.BottomTabScreen

@Composable
fun BottomAppScreen(
    onUnitsClicked: () -> Unit = {},
    onReportsClicked: () -> Unit = {},
    onContactsClicked: () -> Unit = {},
    onCoastsClicked: () -> Unit = {},
    onUsersClicked: () -> Unit = {},
    modifier: Modifier = Modifier
){

    var selectedItem by remember { mutableStateOf(3) }
    val items = listOf(
        NavItem("خانه", painterResource(id = R.drawable.vc_home)),
        NavItem("اعضا", painterResource(id = R.drawable.vc_users)),
        NavItem("گزارشات", painterResource(id = R.drawable.vc_report)),
        NavItem("مخاطبین", painterResource(id = R.drawable.vc_contact)),
        NavItem("هزینه ها", painterResource(id = R.drawable.vc_dollar))
    )

      BottomAppBar {
          items.forEachIndexed { index, item ->
              NavigationBarItem(selected = selectedItem == index,
                  onClick = { selectedItem = index },
                  icon = {
                      Icon(
                          painter = item.icon,
                          contentDescription = item.label,
                          tint = if (selectedItem == index) Color.Black else Water
                      )
                  }
              )
          }

      }

}

data class NavItem(val label: String, val icon: Painter)

@Preview(
    showBackground = true,
    apiLevel = 26,
    device = "spec:width=309dp,height=688dp,dpi=480"
)
@Composable
fun BottomPreview() {
    AtiselTheme {
        BottomTabScreen()
    }
}