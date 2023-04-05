package slimemod.cards;

import slimemod.character.MyCharacter;
import slimemod.util.CardInfo;
import static slimemod.BasicMod.makeID;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class MagiculeControlCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "MagiculeControlCard", // Card ID. Will be prefixed with mod id, so the final ID will be "modID:MyCard"
                              // with whatever your mod's ID is.
            1, // The card's base cost. -1 is X cost, -2 is no cost for unplayable cards like
               // curses, or Reflex.
            CardType.POWER, // The type. ATTACK/SKILL/POWER/CURSE/STATUS
            CardTarget.ENEMY, // The target. Single target is ENEMY, all enemies is ALL_ENEMY. Look at cards
                              // similar to what you want to see what to use.
            CardRarity.COMMON, // Rarity. BASIC is for starting cards, then there's COMMON/UNCOMMON/RARE, and
                               // then SPECIAL and CURSE. SPECIAL is for cards you only get from events. Curse
                               // is for curses, except for special curses like Curse of the Bell and
                               // Necronomicurse.
                               CardColor.RED // The card color. If you're making your own character, it'll look something
                                         // like this. Otherwise, it'll be CardColor.RED or something similar for a
                                         // basegame character color.
    );
    public static final String ID = makeID(cardInfo.baseId);
    private static final int DAMAGE = 5;
    private static final int UPG_DAMAGE = 2;
    private static final int BLOCK = 5;
    private static final int UPG_BLOCK = 2;

    public MagiculeControlCard() {
        super(cardInfo); // Pass the cardInfo to the BaseCard constructor.

        setDamage(DAMAGE, UPG_DAMAGE); //Sets the card's damage and how much it increases when upgraded.
        setBlock(BLOCK, UPG_BLOCK); //Sets the card's Block and how much it increases when upgraded.
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
    }
}
