package com.miniclip.matchsimulator.ui.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.miniclip.matchsimulator.R
import com.miniclip.matchsimulator.ui.theme.Dimens

@Composable
fun CustomTopBar(
    onMatchesClick: () -> Unit,
    onTableClick: () -> Unit,
    onStatsClick: () -> Unit,
    onResetClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedTab by rememberSaveable { mutableIntStateOf(0) }

    Surface(
        color = Color.Transparent,
        shadowElevation = Dimens.padding_4
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(Dimens.TopBarHeight)
                .padding(horizontal = Dimens.padding_8, vertical = Dimens.padding_4),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Left circular image icon
            IconButton(onClick = { /* handle profile click */ }) {
                Image(
                    painter = painterResource(id = R.drawable.ajax),
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
                val tabs = listOf(
                    TabItem(stringResource(id = R.string.matches), 0, TEST_TAG_MATCHES) {
                        selectedTab = 0; onMatchesClick()
                    },
                    TabItem(stringResource(id = R.string.table), 1, TEST_TAG_TABLE) {
                        selectedTab = 1; onTableClick()
                    },
                    TabItem(stringResource(id = R.string.stats), 2, TEST_TAG_STATS) {
                        selectedTab = 2; onStatsClick()
                    }
                )
                tabs.forEachIndexed { i, tab ->
                    TabButton(
                        label = tab.label,
                        selected = selectedTab == tab.index,
                        testTag = tab.testTag,
                        onClick = tab.onClick
                    )
                    if (i < tabs.lastIndex) {
                        Spacer(modifier = Modifier.width(Dimens.padding_30))
                    }
                }
            }

            // Right reset icon
            IconButton(modifier = Modifier.testTag(TEST_TAG_RESET), onClick = onResetClick) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_reset),
                    contentDescription = stringResource(id = R.string.reset),
                    tint = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 640, heightDp = 56, apiLevel = 34)
@Composable
fun CustomTopBarPreview() {
    CustomTopBar(
        onMatchesClick = {},
        onTableClick = {},
        onStatsClick = {},
        onResetClick = {}
    )
}

const val TEST_TAG_MATCHES = "matches"
const val TEST_TAG_TABLE = "table"
const val TEST_TAG_STATS = "stats"
const val TEST_TAG_RESET = "reset"
