package com.miniclip.matchsimulator.ui.matches.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
import com.miniclip.matchsimulator.data.model.MatchEntity

@Composable
fun MatchCard(
    match: MatchEntity,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .height(120.dp)
            .clip(RoundedCornerShape(12.dp)),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "${match.homeTeam} vs ${match.awayTeam}",
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                if (match.homeScore != null && match.awayScore != null) {
                    Text(
                        text = "Score: ${match.homeScore} - ${match.awayScore}",
                        fontSize = 14.sp
                    )
                } else {
                    Text(
                        text = "Not played yet",
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}