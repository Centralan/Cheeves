package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;

public class MineChampion extends Achievement implements IPlayerCustomEvent
{
	public MineChampion(AchievementHandler handler)
	{
		super(handler);
	}

	@Override
	public String getAchievementName()
	{
		return "Mine Champion";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Beat all 5 Rounds of the Mine Arena.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.MINE_CHAMPION.ordinal();
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("achievement.minechampion"))
			award(event.getPlayer());
	}
}
