package com.miniclip.matchsimulator.ui.matches.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import com.miniclip.matchsimulator.data.model.MatchEntity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.miniclip.matchsimulator.ui.theme.Dimens

@Composable
fun MatchCard(
    match: MatchEntity,
    modifier: Modifier = Modifier,
    onMatchClick: (MatchEntity) -> Unit
) {
    // MatchCard displays match details with a blurred background
    Card(
        modifier = modifier
            .height(Dimens.MatchCardHeight)
            .padding(horizontal = Dimens.padding_25)
            .clip(RoundedCornerShape(Dimens.MatchCardCornerRadius))
            .clickable { onMatchClick(match) },
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        // The card contains a blurred background and match details
        Box(modifier = Modifier.fillMaxSize()) {
            // Blurred background layer
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .blur(Dimens.padding_30)
                    .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.6f))
            )
            // Content layer
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(Dimens.padding_16),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Home team logo
                Image(
                    painter = painterResource(id = match.homeTeamLogo),
                    contentDescription = match.homeTeam,
                    modifier = Modifier
                        .size(Dimens.TeamLogoSize)
                        .clip(CircleShape)
                )

                // Match score
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
                        fontSize = Dimens.font_30,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }

                // Away team logo
                Image(
                    painter = painterResource(id = match.awayTeamLogo),
                    contentDescription = match.awayTeam,
                    modifier = Modifier
                        .size(Dimens.TeamLogoSize)
                        .clip(CircleShape)
                )
            }
            
            // Match date and time at the bottom
            Text(
                text = "${match.matchDate} | ${match.matchTime}",
                fontSize = Dimens.font_12,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = Dimens.padding_8)
            )
        }
    }
}