package no.runsafe.cheeves.commands;

import no.runsafe.cheeves.AchievementFinder;
import no.runsafe.cheeves.IAchievement;
import no.runsafe.framework.api.command.ExecutableCommand;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.command.argument.IArgumentList;
import no.runsafe.framework.api.command.argument.TrailingArgument;

public class AchievementLookup extends ExecutableCommand
{
	public AchievementLookup(AchievementFinder achievementFinder)
	{
		super("lookup", "Lookup information on an achievement", "runsafe.cheeves.lookup", new TrailingArgument("achievementTitle"));
		this.achievementFinder = achievementFinder;
	}

	@Override
	public String OnExecute(ICommandExecutor executor, IArgumentList parameters)
	{
		IAchievement achievement = this.achievementFinder.getAchievementByTitle(parameters.getValue("achievementTitle"));
		if (achievement != null)
			return String.format("&3%s - &f%s", achievement.getAchievementName(), achievement.getAchievementInfo());

		return "&cSorry, no achievement with that title could be found.";
	}

	private final AchievementFinder achievementFinder;
}
