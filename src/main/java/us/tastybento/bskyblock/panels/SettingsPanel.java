package us.tastybento.bskyblock.panels;

import us.tastybento.bskyblock.BSkyBlock;
import us.tastybento.bskyblock.api.commands.User;
import us.tastybento.bskyblock.api.flags.Flag;
import us.tastybento.bskyblock.api.panels.PanelItem;
import us.tastybento.bskyblock.api.panels.builders.PanelBuilder;
import us.tastybento.bskyblock.api.panels.builders.PanelItemBuilder;

/**
 * @author Poslovitch
 */
public class SettingsPanel {

    /**
     * Dynamically creates the panel.
     * @param user the User to show the panel to
     */
    public static void openPanel(User user) {
        PanelBuilder panelBuilder = new PanelBuilder()
                .setName(user.getTranslation("protection.panel.title"));

        PanelItem help = new PanelItemBuilder()
                .name(user.getTranslation("protection.panel.help-item.name"))
                .icon("crashdummie99") // Question marks
                .build();

        panelBuilder.addItem(8, help);

        for (Flag flag : BSkyBlock.getInstance().getFlagsManager().getFlags()) {
            PanelItem flagIcon = flag.toPanelItem(user);
            panelBuilder.addItem(flagIcon);
        }

        panelBuilder.build().open(user);
    }
}
