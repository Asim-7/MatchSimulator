package com.miniclip.matchsimulator.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.miniclip.matchsimulator.R

@Composable
fun CustomTopBar(
    onMatchesClick: () -> Unit,
    onTableClick: () -> Unit,
    onStatsClick: () -> Unit,
    onResetClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedTab by remember { mutableIntStateOf(0) }

    Surface(
        color = MaterialTheme.colorScheme.primary,
        shadowElevation = 4.dp
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Left circular image icon
            IconButton(onClick = { /* handle profile click */ }) {
                Image(
                    painter = painterResource(id = R.drawable.ic_profile), // replace with your image
                    contentDescription = "Profile",
                    modifier = Modifier.clip(CircleShape)
                )
            }

            // Center buttons
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        selectedTab = 0
                        onMatchesClick()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (selectedTab == 0) Color.White else MaterialTheme.colorScheme.primary,
                        contentColor = if (selectedTab == 0) MaterialTheme.colorScheme.primary else Color.White
                    )
                ) { Text("Matches") }
                Spacer(modifier = Modifier.width(30.dp))
                Button(
                    onClick = {
                        selectedTab = 1
                        onTableClick()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (selectedTab == 1) Color.White else MaterialTheme.colorScheme.primary,
                        contentColor = if (selectedTab == 1) MaterialTheme.colorScheme.primary else Color.White
                    )
                ) { Text("Table") }
                Spacer(modifier = Modifier.width(30.dp))
                Button(
                    onClick = {
                        selectedTab = 2
                        onStatsClick()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (selectedTab == 2) Color.White else MaterialTheme.colorScheme.primary,
                        contentColor = if (selectedTab == 2) MaterialTheme.colorScheme.primary else Color.White
                    )
                ) { Text("Stats") }
            }

            // Right reset icon
            IconButton(onClick = onResetClick) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_reset), // replace with your reset icon
                    contentDescription = "Reset"
                )
            }
        }
    }
}
