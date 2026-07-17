package co.nidmight.blighttweaks.recipes.removals;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.pam.harvestcraft.BlockRegistry;
import com.pam.harvestcraft.ItemRegistry;

import co.nidmight.blighttweaks.BlightCore;
import co.nidmight.blighttweaks.recipes.helpers.Priority;
import co.nidmight.blighttweaks.recipes.helpers.IGameEditor;
import co.nidmight.blighttweaks.recipes.helpers.RecipeEditorUtil;

public class HarvestCraftRemovals implements IGameEditor {

    @Override
    public void apply() {
        removeRecipes();
        removeOredictEntries();
    }

    @Override
    public Priority getPriority() {
        return Priority.HIGHEST;
    }

    public void removeRecipes() {
        // spotless:off
        Item[] itemsToRemove = new Item[] { ItemRegistry.almondbutterItem, Item.getItemFromBlock(BlockRegistry.pamanimalTrap), ItemRegistry.applejellysandwichItem, ItemRegistry.applesmoothieItem, ItemRegistry.apricotglazedporkItem, ItemRegistry.apricotItem, ItemRegistry.apricotjellyItem, ItemRegistry.apricotjellysandwichItem, ItemRegistry.apricotjuiceItem, ItemRegistry.apricotsmoothieItem, ItemRegistry.apricotyogurtItem, ItemRegistry.artichokeItem, ItemRegistry.artichokeseedItem, ItemRegistry.asparagusItem, ItemRegistry.asparagusquicheItem, ItemRegistry.asparagussoupItem, ItemRegistry.avocadoburritoItem, ItemRegistry.avocadoItem, ItemRegistry.baconwrappeddatesItem, ItemRegistry.bakedbeansItem, ItemRegistry.bakedbeetsItem, ItemRegistry.bakedsweetpotatoItem, ItemRegistry.baklavaItem, ItemRegistry.bambooshootItem, ItemRegistry.bambooshootseedItem, ItemRegistry.bamboosteamedriceItem, ItemRegistry.bananaItem, ItemRegistry.bananamilkshakeItem, ItemRegistry.banananutbreadItem, ItemRegistry.bananasmoothieItem, ItemRegistry.bananasplitItem, ItemRegistry.bananayogurtItem, ItemRegistry.barleyItem, ItemRegistry.barleyseedItem, ItemRegistry.bbqpulledporkItem, ItemRegistry.beanburritoItem, ItemRegistry.beanItem, ItemRegistry.beansandriceItem, ItemRegistry.beanseedItem, ItemRegistry.beansontoastItem, ItemRegistry.beefjerkyItem, ItemRegistry.beefwellingtonItem, ItemRegistry.beetburgerItem, ItemRegistry.beetItem, ItemRegistry.beetsaladItem, ItemRegistry.beetseedItem, ItemRegistry.beetsoupItem, ItemRegistry.bellpepperItem, ItemRegistry.bellpepperseedItem, ItemRegistry.biscuitItem, ItemRegistry.blackberryItem, ItemRegistry.blackberryjellysandwichItem, ItemRegistry.blackberryseedItem, ItemRegistry.bltItem, ItemRegistry.blueberryItem, ItemRegistry.blueberryjellysandwichItem, ItemRegistry.blueberryseedItem, ItemRegistry.braisedonionsItem, ItemRegistry.broccoliItem, ItemRegistry.broccolindipItem, ItemRegistry.brownieItem, ItemRegistry.brusselsproutItem, ItemRegistry.brusselsproutseedItem, ItemRegistry.cabbageItem, ItemRegistry.cactusfruitItem, ItemRegistry.cactusfruitjuiceItem, ItemRegistry.cactusfruitseedItem, ItemRegistry.californiarollItem, ItemRegistry.candiedgingerItem, ItemRegistry.candiedlemonItem, ItemRegistry.candiedsweetpotatoesItem, ItemRegistry.candiedwalnutsItem, ItemRegistry.candleberryseedItem, ItemRegistry.cantaloupeseedItem, ItemRegistry.cashewbutterItem, ItemRegistry.cashewchickenItem, ItemRegistry.cauliflowerseedItem, ItemRegistry.ceasarsaladItem, ItemRegistry.celeryandpeanutbutterItem, ItemRegistry.celeryseedItem, ItemRegistry.celerysoupItem, ItemRegistry.chaiteaItem, ItemRegistry.chaoscookieItem, ItemRegistry.cheeseontoastItem, ItemRegistry.cherrycheesecakeItem, ItemRegistry.cherrycoconutchocolatebarItem, ItemRegistry.cherryicecreamItem, ItemRegistry.cherryjellyItem, ItemRegistry.cherryjellysandwichItem, ItemRegistry.cherryjuiceItem, ItemRegistry.cherrypieItem, ItemRegistry.cherrysmoothieItem, ItemRegistry.cherrysodaItem, ItemRegistry.cherryyogurtItem, ItemRegistry.chestnutbutterItem, ItemRegistry.chickencelerycasseroleItem, ItemRegistry.chickencurryItem, ItemRegistry.chickengumboItem, ItemRegistry.chikorollItem, ItemRegistry.chilichocolateItem, ItemRegistry.chiliItem, ItemRegistry.chilipepperseedItem, ItemRegistry.chilipoppersItem, ItemRegistry.chocolatebaconItem, ItemRegistry.chocolatebarItem, ItemRegistry.chocolatecaramelfudgeItem, ItemRegistry.chocolatecherryItem, ItemRegistry.chocolatedonutItem, ItemRegistry.chocolateicecreamItem, ItemRegistry.chocolatemilkItem, ItemRegistry.chocolatemilkshakeItem, ItemRegistry.chocolaterollItem, ItemRegistry.chocolatesprinklecakeItem, ItemRegistry.chocolatestrawberryItem, ItemRegistry.chocolateyogurtItem, ItemRegistry.chorizoItem, Item.getItemFromBlock(BlockRegistry.pamChurn), ItemRegistry.cinnamonappleoatmealItem, ItemRegistry.cinnamonItem, ItemRegistry.cinnamonrollItem, ItemRegistry.cinnamonsugardonutItem, ItemRegistry.citrussaladItem, ItemRegistry.cocoapowderItem, ItemRegistry.coconutcreamItem, ItemRegistry.coconutmilkItem, ItemRegistry.coconutshrimpItem, ItemRegistry.coconutsmoothieItem, ItemRegistry.coconutyogurtItem, ItemRegistry.coffeeconlecheItem, ItemRegistry.coffeeItem, ItemRegistry.coffeeseedItem, ItemRegistry.coleslawburgerItem, ItemRegistry.cornbreadItem, ItemRegistry.cornflakesItem, ItemRegistry.cornishpastyItem, ItemRegistry.cornmealItem, ItemRegistry.cornonthecobItem, ItemRegistry.cornseedItem, ItemRegistry.cottagepieItem, ItemRegistry.cottonItem, ItemRegistry.cottonseedItem, ItemRegistry.crackerItem, ItemRegistry.cranberrybarItem, ItemRegistry.cranberryjellyItem, ItemRegistry.cranberryjellysandwichItem, ItemRegistry.cranberryjuiceItem, ItemRegistry.cranberrysauceItem, ItemRegistry.cranberryseedItem, ItemRegistry.cranberrysmoothieItem, ItemRegistry.cranberryyogurtItem, ItemRegistry.creamcookieItem, ItemRegistry.creamedcornItem, ItemRegistry.creamofavocadosoupItem, ItemRegistry.croissantItem, ItemRegistry.cucumberItem, ItemRegistry.cucumbersaladItem, ItemRegistry.curryItem, ItemRegistry.curryleafItem, ItemRegistry.curryleafseedItem, ItemRegistry.currypowderItem, ItemRegistry.custardItem, Item.getItemFromBlock(BlockRegistry.pamcuttingBoard), ItemRegistry.delightedmealItem, ItemRegistry.deluxecheeseburgerItem, ItemRegistry.deluxechickencurryItem, ItemRegistry.dimsumItem, ItemRegistry.eggnogItem, ItemRegistry.eggplantItem, ItemRegistry.espressoItem, ItemRegistry.extremechiliItem, ItemRegistry.figbarItem, ItemRegistry.figjellyItem, ItemRegistry.figjellysandwichItem, ItemRegistry.figjuiceItem, ItemRegistry.figsmoothieItem, ItemRegistry.figyogurtItem, ItemRegistry.firmtofuItem, ItemRegistry.fishdinnerItem, ItemRegistry.fishlettucewrapItem, ItemRegistry.fishtacoItem, Item.getItemFromBlock(BlockRegistry.pamfishTrap), ItemRegistry.fishtrapbaitItem, ItemRegistry.footlongItem, ItemRegistry.frenchtoastItem, ItemRegistry.freshmilkItem, ItemRegistry.friedonionsItem, ItemRegistry.friedpecanokraItem, ItemRegistry.friedriceItem, ItemRegistry.fruitbaitItem, ItemRegistry.fruitcrumbleItem, ItemRegistry.futomakiItem, ItemRegistry.garammasalaItem, ItemRegistry.garlicbreadItem, ItemRegistry.garlicchickenItem, ItemRegistry.garlicmashedpotatoesItem, ItemRegistry.garlicseedItem, ItemRegistry.generaltsochickenItem, ItemRegistry.gingerbreadItem, ItemRegistry.gingerchickenItem, ItemRegistry.gingeredrhubarbtartItem, ItemRegistry.gingerseedItem, ItemRegistry.gingersnapsItem, ItemRegistry.gingersodaItem, ItemRegistry.gooseberryjellyItem, ItemRegistry.gooseberryjellysandwichItem, ItemRegistry.gooseberrymilkshakeItem, ItemRegistry.gooseberrypieItem, ItemRegistry.gooseberrysmoothieItem, ItemRegistry.gooseberryyogurtItem, ItemRegistry.grainbaitItem, ItemRegistry.grapefruitjellyItem, ItemRegistry.grapefruitjellysandwichItem, ItemRegistry.grapefruitjuiceItem, ItemRegistry.grapefruitsmoothieItem, ItemRegistry.grapefruitsodaItem, ItemRegistry.grapefruityogurtItem, ItemRegistry.grapejellyItem, ItemRegistry.grapejuiceItem, ItemRegistry.grapesaladItem, ItemRegistry.grapeseedItem, ItemRegistry.grapesmoothieItem, ItemRegistry.grapesodaItem, ItemRegistry.grapeyogurtItem, ItemRegistry.gravyItem, ItemRegistry.greenheartfishItem, ItemRegistry.grilledskewersItem, ItemRegistry.groundcinnamonItem, ItemRegistry.groundnutmegItem, ItemRegistry.guacamoleItem, ItemRegistry.hamsweetpicklesandwichItem, ItemRegistry.hashItem, ItemRegistry.heartybreakfastItem, ItemRegistry.holidaycakeItem, ItemRegistry.honeycombchocolatebarItem, ItemRegistry.honeylemonlambItem, ItemRegistry.honeysandwichItem, ItemRegistry.hotchocolateItem, ItemRegistry.hotwingsItem, ItemRegistry.hushpuppiesItem, ItemRegistry.jaffaItem, ItemRegistry.jamrollItem, ItemRegistry.jellydonutItem, ItemRegistry.keylimepieItem, ItemRegistry.kimchiItem, ItemRegistry.kiwijellyItem, ItemRegistry.kiwijellysandwichItem, ItemRegistry.kiwijuiceItem, ItemRegistry.kiwiseedItem, ItemRegistry.kiwismoothieItem, ItemRegistry.kiwiyogurtItem, ItemRegistry.lambbarleysoupItem, ItemRegistry.lambkebabItem, ItemRegistry.lambwithmintsauceItem, ItemRegistry.lamingtonItem, ItemRegistry.leafychickensandwichItem, ItemRegistry.leafyfishsandwichItem, ItemRegistry.leekbaconsoupItem, ItemRegistry.leekseedItem, ItemRegistry.lemonaideItem, ItemRegistry.lemonbarItem, ItemRegistry.lemonchickenItem, ItemRegistry.lemonjellyItem, ItemRegistry.lemonjellysandwichItem, ItemRegistry.lemonlimesodaItem, ItemRegistry.lemonmeringueItem, ItemRegistry.lemonsmoothieItem, ItemRegistry.lemonyogurtItem, ItemRegistry.lettuceseedItem, ItemRegistry.limejellyItem, ItemRegistry.limejellysandwichItem, ItemRegistry.limejuiceItem, ItemRegistry.limesmoothieItem, ItemRegistry.limeyogurtItem, ItemRegistry.mangochutneyItem, ItemRegistry.mangojellyItem, ItemRegistry.mangojellysandwichItem, ItemRegistry.mangojuiceItem, ItemRegistry.mangosmoothieItem, ItemRegistry.mangoyogurtItem, ItemRegistry.manjuuItem, ItemRegistry.maplecandiedbaconItem, ItemRegistry.mapleoatmealItem, ItemRegistry.maplesausageItem, ItemRegistry.maplesyruppancakesItem, ItemRegistry.maplesyrupwafflesItem, ItemRegistry.marinatedcucumbersItem, Item.getItemFromBlock(BlockRegistry.pamMarket), ItemRegistry.marzipanItem, ItemRegistry.mashedsweetpotatoesItem, ItemRegistry.mcpamItem, ItemRegistry.meatfeastpizzaItem, ItemRegistry.meatpieItem, ItemRegistry.mintchocolatechipicemcreamItem, ItemRegistry.mixedsaladItem, ItemRegistry.mochaicecreamItem, ItemRegistry.mochiItem, ItemRegistry.museliItem, ItemRegistry.mushroomrisottoItem, ItemRegistry.mustardseedItem, ItemRegistry.mustardseedsItem, ItemRegistry.naanItem, ItemRegistry.nachoesItem, ItemRegistry.neapolitanicecreamItem, ItemRegistry.nutellaItem, ItemRegistry.oatsseedItem, ItemRegistry.okrachipsItem, ItemRegistry.okracreoleItem, ItemRegistry.okraseedItem, ItemRegistry.oldworldveggiesoupItem, ItemRegistry.omeletItem, ItemRegistry.onionhamburgerItem, ItemRegistry.onionseedItem, ItemRegistry.onionsoupItem, ItemRegistry.orangechickenItem, ItemRegistry.orangejellyItem, ItemRegistry.orangejellysandwichItem, ItemRegistry.orangejuiceItem, ItemRegistry.orangesmoothieItem, ItemRegistry.orangesodaItem, ItemRegistry.orangeyogurtItem, ItemRegistry.ovenroastedcauliflowerItem, Item.getItemFromBlock(BlockRegistry.pamapricotSapling), Item.getItemFromBlock(BlockRegistry.pamavocadoSapling), Item.getItemFromBlock(BlockRegistry.pambananaSapling), Item.getItemFromBlock(BlockRegistry.pamcarrotCake), Item.getItemFromBlock(BlockRegistry.pamcashewSapling), Item.getItemFromBlock(BlockRegistry.pamcheeseCake), Item.getItemFromBlock(BlockRegistry.pamcherrycheeseCake), Item.getItemFromBlock(BlockRegistry.pamcherrySapling), Item.getItemFromBlock(BlockRegistry.pamchocolatesprinkleCake), Item.getItemFromBlock(BlockRegistry.pamcinnamonSapling), Item.getItemFromBlock(BlockRegistry.pamcoconutSapling), Item.getItemFromBlock(BlockRegistry.pamdragonfruitSapling), Item.getItemFromBlock(BlockRegistry.pamdurianSapling), Item.getItemFromBlock(BlockRegistry.pamfigSapling), Item.getItemFromBlock(BlockRegistry.pamgooseberrySapling), Item.getItemFromBlock(BlockRegistry.pamgrapefruitSapling), Item.getItemFromBlock(BlockRegistry.pamholidayCake), Item.getItemFromBlock(BlockRegistry.pamlamingtonCake), Item.getItemFromBlock(BlockRegistry.pamlemonSapling), Item.getItemFromBlock(BlockRegistry.pamlimeSapling), Item.getItemFromBlock(BlockRegistry.pammangoSapling), Item.getItemFromBlock(BlockRegistry.pammapleSapling), Item.getItemFromBlock(BlockRegistry.pamnutmegSapling), Item.getItemFromBlock(BlockRegistry.pamorangeSapling), Item.getItemFromBlock(BlockRegistry.pampapayaSapling), Item.getItemFromBlock(BlockRegistry.pampaperbarkSapling), Item.getItemFromBlock(BlockRegistry.pampavlovaCake), Item.getItemFromBlock(BlockRegistry.pampeachSapling), Item.getItemFromBlock(BlockRegistry.pampearSapling), Item.getItemFromBlock(BlockRegistry.pampecanSapling), Item.getItemFromBlock(BlockRegistry.pampersimmonSapling), Item.getItemFromBlock(BlockRegistry.pampineappleupsidedownCake), Item.getItemFromBlock(BlockRegistry.pamplumSapling), Item.getItemFromBlock(BlockRegistry.pampomegranateSapling), Item.getItemFromBlock(BlockRegistry.pampumpkincheeseCake), Item.getItemFromBlock(BlockRegistry.pamstarfruitSapling), Item.getItemFromBlock(BlockRegistry.pamvanillabeanSapling), Item.getItemFromBlock(BlockRegistry.pamwalnutSapling), ItemRegistry.paneerItem, ItemRegistry.paneertikkamasalaItem, ItemRegistry.papayajellyItem, ItemRegistry.papayajellysandwichItem, ItemRegistry.papayajuiceItem, ItemRegistry.papayasmoothieItem, ItemRegistry.papayayogurtItem, ItemRegistry.parsnipItem, ItemRegistry.pavlovaItem, ItemRegistry.pbandjItem, ItemRegistry.peaandhamsoupItem, ItemRegistry.peachcobblerItem, ItemRegistry.peachesandcreamoatmealItem, ItemRegistry.peachjellyItem, ItemRegistry.peachjellysandwichItem, ItemRegistry.peachjuiceItem, ItemRegistry.peachsmoothieItem, ItemRegistry.peachyogurtItem, ItemRegistry.peanutbuttercookiesItem, ItemRegistry.peanutbutterItem, ItemRegistry.peanutseedItem, ItemRegistry.pearjellyItem, ItemRegistry.pearjellysandwichItem, ItemRegistry.pearjuiceItem, ItemRegistry.pearsmoothieItem, ItemRegistry.pearyogurtItem, ItemRegistry.peasandceleryItem, ItemRegistry.peasItem, ItemRegistry.pecanpieItem, ItemRegistry.peppercornItem, ItemRegistry.pepperoniItem, ItemRegistry.persimmonjellyItem, ItemRegistry.persimmonjellysandwichItem, ItemRegistry.persimmonjuiceItem, ItemRegistry.persimmonsmoothieItem, ItemRegistry.persimmonyogurtItem, ItemRegistry.pickledbeetsItem, ItemRegistry.pickledonionsItem, ItemRegistry.picklesItem, ItemRegistry.pinacoladaItem, ItemRegistry.pineapplehamItem, ItemRegistry.pineappleseedItem, ItemRegistry.pineappleupsidedowncakeItem, ItemRegistry.pineappleyogurtItem, ItemRegistry.pistachiobutterItem, ItemRegistry.pistachioicecreamItem, ItemRegistry.ploughmanslunchItem, ItemRegistry.plumjellyItem, ItemRegistry.plumjellysandwichItem, ItemRegistry.plumjuiceItem, ItemRegistry.plumsmoothieItem, ItemRegistry.plumyogurtItem, ItemRegistry.poachedpearItem, ItemRegistry.pomegranatejellyItem, ItemRegistry.pomegranatejellysandwichItem, ItemRegistry.pomegranatejuiceItem, ItemRegistry.pomegranatesmoothieItem, ItemRegistry.pomegranateyogurtItem, ItemRegistry.popcornItem, ItemRegistry.porklettucewrapItem, ItemRegistry.porklomeinItem, ItemRegistry.potatoandleeksoupItem, ItemRegistry.potatocakesItem, ItemRegistry.pralinesItem, ItemRegistry.pumpkinoatsconesItem, Item.getItemFromBlock(BlockRegistry.pamQuern), ItemRegistry.radishseedItem, ItemRegistry.rainbowcurryItem, ItemRegistry.raisincookiesItem, ItemRegistry.randomtacoItem, ItemRegistry.raspberryicedteaItem, ItemRegistry.raspberryItem, ItemRegistry.raspberryjellysandwichItem, ItemRegistry.raspberryseedItem, ItemRegistry.raspberrytrifleItem, ItemRegistry.refriedbeansItem, ItemRegistry.rhubarbseedItem, ItemRegistry.ricecakeItem, ItemRegistry.riceseedItem, ItemRegistry.ricesoupItem, ItemRegistry.roastchickenItem, ItemRegistry.roastedpumpkinseedsItem, ItemRegistry.roastedrootveggiemedleyItem, ItemRegistry.roastpotatoesItem, ItemRegistry.rutabagaseedItem, ItemRegistry.ryeseedItem, ItemRegistry.saladdressingItem, ItemRegistry.salmonpattiesItem, ItemRegistry.sausageinbreadItem, ItemRegistry.sausageItem, ItemRegistry.sausagerollItem, ItemRegistry.scallionItem, ItemRegistry.seaweedItem, ItemRegistry.seaweedseedItem, ItemRegistry.sesameballItem, ItemRegistry.sesameseedsseedItem, ItemRegistry.sesamesnapsItem, ItemRegistry.shepardspieItem, ItemRegistry.shrimpokrahushpuppiesItem, ItemRegistry.silkentofuItem, ItemRegistry.snickersbarItem, ItemRegistry.softpretzelandmustardItem, ItemRegistry.soybeanseedItem, ItemRegistry.soymilkItem, ItemRegistry.soysauceItem, ItemRegistry.spicebunItem, ItemRegistry.spiceleafItem, ItemRegistry.spicygreensItem, ItemRegistry.spicymustardporkItem, ItemRegistry.spinachpieItem, ItemRegistry.spinachseedItem, ItemRegistry.springsaladItem, ItemRegistry.spumoniicecreamItem, ItemRegistry.starfruitjellyItem, ItemRegistry.starfruitjellysandwichItem, ItemRegistry.starfruitjuiceItem, ItemRegistry.starfruitsmoothieItem, ItemRegistry.starfruityogurtItem, ItemRegistry.steakandchipsItem, ItemRegistry.strawberryicecreamItem, ItemRegistry.strawberryjellyItem, ItemRegistry.strawberryjellysandwichItem, ItemRegistry.strawberryjuiceItem, ItemRegistry.strawberrymilkshakeItem, ItemRegistry.strawberrypieItem, ItemRegistry.strawberrysaladItem, ItemRegistry.strawberryseedItem, ItemRegistry.strawberrysmoothieItem, ItemRegistry.strawberrysodaItem, ItemRegistry.strawberryyogurtItem, ItemRegistry.stuffedeggplantItem, ItemRegistry.stuffedpepperItem, ItemRegistry.summerradishsaladItem, ItemRegistry.summersquashwithradishItem, ItemRegistry.sundayroastItem, ItemRegistry.supremepizzaItem, ItemRegistry.sushiItem, ItemRegistry.sweetpickleItem, ItemRegistry.sweetpotatopieItem, ItemRegistry.sweetpotatoseedItem, ItemRegistry.sweetpotatosouffleItem, ItemRegistry.tacoItem, ItemRegistry.teaItem, ItemRegistry.teaseedItem, ItemRegistry.timtamItem, ItemRegistry.toadintheholeItem, ItemRegistry.toastedcoconutItem, ItemRegistry.toastedsesameseedsItem, ItemRegistry.toastsandwichItem, ItemRegistry.tomatoItem, ItemRegistry.tortillaItem, ItemRegistry.trailmixItem, ItemRegistry.tunapotatoItem, ItemRegistry.turnipItem, ItemRegistry.vanillaicecreamItem, ItemRegistry.vanillaItem, ItemRegistry.vanillayogurtItem, ItemRegistry.vegemiteontoastItem, ItemRegistry.vegetarianlettucewrapItem, ItemRegistry.veggiebaitItem, ItemRegistry.veggiestirfryItem, ItemRegistry.veggiestripsItem, ItemRegistry.vindalooItem, ItemRegistry.vinegarItem, ItemRegistry.walnutraisinbreadItem, ItemRegistry.waterchestnutseedItem, ItemRegistry.watermelonjellysandwichItem, ItemRegistry.whitemushroomseedItem, ItemRegistry.wintersquashseedItem, ItemRegistry.yorkshirepuddingItem, ItemRegistry.zeppoleItem, ItemRegistry.zestyzucchiniItem, ItemRegistry.zombiejerkyItem, ItemRegistry.zucchinibakeItem, ItemRegistry.zucchinibreadItem, ItemRegistry.zucchiniItem, ItemRegistry.flourItem, ItemRegistry.freshwaterItem, ItemRegistry.hotdogItem, ItemRegistry.loadedbakedpotatoItem, ItemRegistry.baconcheeseburgerItem, ItemRegistry.epicbaconItem };
        // spotless:on
        for (Item item : itemsToRemove) {
            if (!RecipeEditorUtil
                .removeRecipeByOutput(new ItemStack(item))) {
                BlightCore.logger.warn("Failed to remove recipe for {}", item.getUnlocalizedName());
            }
        }
    }

    public void removeOredictEntries() {
        RecipeEditorUtil.removeItemFromOreDict("listAllberry", ItemRegistry.blackberryItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllberry", ItemRegistry.blueberryItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllberry", ItemRegistry.cranberryItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllberry", ItemRegistry.raspberryItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllberry", ItemRegistry.strawberryItem);

        RecipeEditorUtil.removeItemFromOreDict("listAllveggie", ItemRegistry.artichokeItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllveggie", ItemRegistry.bambooshootItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllveggie", ItemRegistry.beanItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllveggie", ItemRegistry.beetItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllveggie", ItemRegistry.bellpepperItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllveggie", ItemRegistry.brusselsproutItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllveggie", ItemRegistry.cauliflowerItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllveggie", ItemRegistry.celeryItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllveggie", ItemRegistry.cornItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllveggie", ItemRegistry.leekItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllveggie", ItemRegistry.lettuceItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllveggie", ItemRegistry.okraItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllveggie", ItemRegistry.onionItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllveggie", ItemRegistry.radishItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllveggie", ItemRegistry.rhubarbItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllveggie", ItemRegistry.rutabagaItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllveggie", ItemRegistry.seaweedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllveggie", ItemRegistry.soybeanItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllveggie", ItemRegistry.spinachItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllveggie", ItemRegistry.sweetpotatoItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllveggie", ItemRegistry.whitemushroomItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllveggie", ItemRegistry.wintersquashItem);

        RecipeEditorUtil.removeItemFromOreDict("listAllspice", ItemRegistry.mustardseedsItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllspice", ItemRegistry.gingerItem);

        RecipeEditorUtil.removeItemFromOreDict("listAllsmoothie", ItemRegistry.bananasmoothieItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllsmoothie", ItemRegistry.cherrysmoothieItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllsmoothie", ItemRegistry.kiwismoothieItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllsmoothie", ItemRegistry.lemonsmoothieItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllsmoothie", ItemRegistry.limesmoothieItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllsmoothie", ItemRegistry.mangosmoothieItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllsmoothie", ItemRegistry.orangesmoothieItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllsmoothie", ItemRegistry.papayasmoothieItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllsmoothie", ItemRegistry.peachsmoothieItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllsmoothie", ItemRegistry.pomegranatesmoothieItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllsmoothie", ItemRegistry.starfruitsmoothieItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllsmoothie", ItemRegistry.strawberrysmoothieItem);

        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.bambooshootseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.barleyseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.beanseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.beetseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.bellpepperseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.blackberryseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.blueberryseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.cactusfruitseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.cantaloupeseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.cauliflowerseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.celeryseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.chilipepperseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.coffeeseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.cornseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.cranberryseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.garlicseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.gingerseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.grapeseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.kiwiseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.leekseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.lettuceseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.mustardseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.oatsseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.onionseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.peanutseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.pineappleseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.radishseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.raspberryseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.rhubarbseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.ryeseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.seaweedseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.soybeanseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.spinachseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.strawberryseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.sweetpotatoseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.teaseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.whitemushroomseedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllseed", ItemRegistry.wintersquashseedItem);

        RecipeEditorUtil.removeItemFromOreDict("listAllrootveggie", ItemRegistry.radishItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllrootveggie", ItemRegistry.rutabagaItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllrootveggie", ItemRegistry.sweetpotatoItem);

        RecipeEditorUtil.removeItemFromOreDict("listAllmushroom", ItemRegistry.whitemushroomItem);

        RecipeEditorUtil.removeItemFromOreDict("listAlljuice", ItemRegistry.cactusfruitjuiceItem);
        RecipeEditorUtil.removeItemFromOreDict("listAlljuice", ItemRegistry.cherryjuiceItem);
        RecipeEditorUtil.removeItemFromOreDict("listAlljuice", ItemRegistry.cranberryjuiceItem);
        RecipeEditorUtil.removeItemFromOreDict("listAlljuice", ItemRegistry.grapejuiceItem);
        RecipeEditorUtil.removeItemFromOreDict("listAlljuice", ItemRegistry.kiwijuiceItem);
        RecipeEditorUtil.removeItemFromOreDict("listAlljuice", ItemRegistry.lemonaideItem);
        RecipeEditorUtil.removeItemFromOreDict("listAlljuice", ItemRegistry.limejuiceItem);
        RecipeEditorUtil.removeItemFromOreDict("listAlljuice", ItemRegistry.mangojuiceItem);
        RecipeEditorUtil.removeItemFromOreDict("listAlljuice", ItemRegistry.orangejuiceItem);
        RecipeEditorUtil.removeItemFromOreDict("listAlljuice", ItemRegistry.papayajuiceItem);
        RecipeEditorUtil.removeItemFromOreDict("listAlljuice", ItemRegistry.peachjuiceItem);
        RecipeEditorUtil.removeItemFromOreDict("listAlljuice", ItemRegistry.pomegranatejuiceItem);
        RecipeEditorUtil.removeItemFromOreDict("listAlljuice", ItemRegistry.starfruitjuiceItem);
        RecipeEditorUtil.removeItemFromOreDict("listAlljuice", ItemRegistry.strawberryjuiceItem);

        RecipeEditorUtil.removeItemFromOreDict("listAllgreenveggie", ItemRegistry.artichokeItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllgreenveggie", ItemRegistry.brusselsproutItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllgreenveggie", ItemRegistry.celeryItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllgreenveggie", ItemRegistry.lettuceItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllgreenveggie", ItemRegistry.okraItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllgreenveggie", ItemRegistry.seaweedItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllgreenveggie", ItemRegistry.spinachItem);

        RecipeEditorUtil.removeItemFromOreDict("listAllgrain", ItemRegistry.barleyItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllgrain", ItemRegistry.oatsItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllgrain", ItemRegistry.ryeItem);

        RecipeEditorUtil.removeItemFromOreDict("listAllfruit", ItemRegistry.apricotItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllfruit", ItemRegistry.bananaItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllfruit", ItemRegistry.blackberryItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllfruit", ItemRegistry.blueberryItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllfruit", ItemRegistry.cactusfruitItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllfruit", ItemRegistry.cantaloupeItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllfruit", ItemRegistry.cherryItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllfruit", ItemRegistry.cranberryItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllfruit", ItemRegistry.dragonfruitItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllfruit", ItemRegistry.figItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllfruit", ItemRegistry.grapefruitItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllfruit", ItemRegistry.grapeItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllfruit", ItemRegistry.kiwiItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllfruit", ItemRegistry.lemonItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllfruit", ItemRegistry.limeItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllfruit", ItemRegistry.mangoItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllfruit", ItemRegistry.orangeItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllfruit", ItemRegistry.papayaItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllfruit", ItemRegistry.peachItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllfruit", ItemRegistry.pearItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllfruit", ItemRegistry.pineappleItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllfruit", ItemRegistry.plumItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllfruit", ItemRegistry.pomegranateItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllfruit", ItemRegistry.raspberryItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllfruit", ItemRegistry.starfruitItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllfruit", ItemRegistry.strawberryItem);

        RecipeEditorUtil.removeItemFromOreDict("listAllnut", ItemRegistry.cashewItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllnut", ItemRegistry.peanutItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllnut", ItemRegistry.pecanItem);
        RecipeEditorUtil.removeItemFromOreDict("listAllnut", ItemRegistry.walnutItem);

        RecipeEditorUtil.removeItemFromOreDict("cropBlackberry", ItemRegistry.blackberryItem);

        RecipeEditorUtil.removeItemFromOreDict("cropBlueberry", ItemRegistry.blueberryItem);

        RecipeEditorUtil.removeItemFromOreDict("cropRaspberry", ItemRegistry.raspberryItem);

    }

}
