package no.runsafe.cheeves.achievements;
 
import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.inventory.IInventoryClick;
import no.runsafe.framework.api.event.player.IPlayerPickupItemEvent;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.event.inventory.RunsafeInventoryClickEvent;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerPickupItemEvent;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

public class Huckleberry Beta extends Achievement implements IInventoryClick, IPlayerPickupItemEvent
{
	public HuckleberryBeta(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}
 
	@Override
	public String getAchievementName()
	{
		return "Huckleberry Beta";
	}
 
	@Override
	public String getAchievementInfo()
	{
		return "Obtain 100 Beta tokens.";
	}
 
	@Override
	public int getAchievementID()
	{
		return Achievements.HUCKLEBERRY_BETA.ordinal();
	}
 
	private void checkInventory(RunsafeInventory inventory, IPlayer player)
	{
		if (player.isInUniverse("survival"))
		{
			int amount = 0;
			for (RunsafeMeta inventoryItem : inventory.getContents())
			{
				if (inventoryItem.is(Item.Materials.NetherWart))
				{
					String displayName = inventoryItem.getDisplayName();
					if (displayName != null && displayName.equals("§4Beta Token"))
					{
						amount += inventoryItem.getAmount();
						if (amount >= 100)
						{
							award(player);
							return;
						}
					}
				}
			}
		}
	}

	@Override
	public void OnInventoryClickEvent(RunsafeInventoryClickEvent event)
	{
		checkInventory(event.getInventory(), event.getWhoClicked());
	}

	@Override
	public void OnPlayerPickupItemEvent(RunsafePlayerPickupItemEvent event)
	{
		IPlayer player = event.getPlayer();
		checkInventory(player.getInventory(), player);
	}
}
