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
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.res.painterResource

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
        Box(modifier = Modifier.fillMaxSize()) {
            // Main row content
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = match.homeTeamLogo),
                    contentDescription = match.homeTeam,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                )
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = if (match.homeScore != null && match.awayScore != null) {
                            "${match.homeScore} - ${match.awayScore}"
                        } else {
                            "vs"
                        },
                        fontSize = 30.sp,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                Image(
                    painter = painterResource(id = match.awayTeamLogo),
                    contentDescription = match.awayTeam,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                )
            }
            // Date and time in the bottom
            Text(
                text = "${match.matchDate} | ${match.matchTime}",
                fontSize = 12.sp,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 8.dp)
            )
        }
    }
}