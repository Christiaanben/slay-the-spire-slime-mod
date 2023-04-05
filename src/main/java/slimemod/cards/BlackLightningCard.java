package slimemod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import slimemod.util.CardInfo;
import static slimemod.BasicMod.makeID;

public class BlackLightningCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "BlackLightningCard", // Card ID. Will be prefixed with mod id, so the final ID will be "modID:MyCard"
            1,
            CardType.ATTACK, // The type.
            CardTarget.ENEMY, // The target.
            CardRarity.COMMON, // Rarity.
            CardColor.RED // The card color.
    );
    public static final String ID = makeID(cardInfo.baseId);
    private static final int DAMAGE = 5;
    private static final int UPG_DAMAGE = 2;
    private static final int BLOCK = 5;
    private static final int UPG_BLOCK = 2;

    public BlackLightningCard() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        setBlock(BLOCK, UPG_BLOCK);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
    }
}
