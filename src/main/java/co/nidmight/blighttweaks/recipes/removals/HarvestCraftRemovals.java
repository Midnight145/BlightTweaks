package co.nidmight.blighttweaks.recipes.removals;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.pam.harvestcraft.BlockRegistry;
import com.pam.harvestcraft.ItemRegistry;

import co.nidmight.blighttweaks.BlightCore;
import co.nidmight.blighttweaks.recipes.framework.Priority;
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
            if (!RecipeEditorUtil.getInstance()
                .removeRecipeByOutput(new ItemStack(item))) {
                BlightCore.logger.warn("Failed to remove recipe for {}", item.getUnlocalizedName());
            }
        }
    }

    public void removeOredictEntries() {
        RecipeEditorUtil oreDictHelper = RecipeEditorUtil.getInstance();
        oreDictHelper.removeItemFromOreDict("listAllberry", ItemRegistry.blackberryItem);
        oreDictHelper.removeItemFromOreDict("listAllberry", ItemRegistry.blueberryItem);
        oreDictHelper.removeItemFromOreDict("listAllberry", ItemRegistry.cranberryItem);
        oreDictHelper.removeItemFromOreDict("listAllberry", ItemRegistry.raspberryItem);
        oreDictHelper.removeItemFromOreDict("listAllberry", ItemRegistry.strawberryItem);

        oreDictHelper.removeItemFromOreDict("listAllveggie", ItemRegistry.artichokeItem);
        oreDictHelper.removeItemFromOreDict("listAllveggie", ItemRegistry.bambooshootItem);
        oreDictHelper.removeItemFromOreDict("listAllveggie", ItemRegistry.beanItem);
        oreDictHelper.removeItemFromOreDict("listAllveggie", ItemRegistry.beetItem);
        oreDictHelper.removeItemFromOreDict("listAllveggie", ItemRegistry.bellpepperItem);
        oreDictHelper.removeItemFromOreDict("listAllveggie", ItemRegistry.brusselsproutItem);
        oreDictHelper.removeItemFromOreDict("listAllveggie", ItemRegistry.cauliflowerItem);
        oreDictHelper.removeItemFromOreDict("listAllveggie", ItemRegistry.celeryItem);
        oreDictHelper.removeItemFromOreDict("listAllveggie", ItemRegistry.cornItem);
        oreDictHelper.removeItemFromOreDict("listAllveggie", ItemRegistry.leekItem);
        oreDictHelper.removeItemFromOreDict("listAllveggie", ItemRegistry.lettuceItem);
        oreDictHelper.removeItemFromOreDict("listAllveggie", ItemRegistry.okraItem);
        oreDictHelper.removeItemFromOreDict("listAllveggie", ItemRegistry.onionItem);
        oreDictHelper.removeItemFromOreDict("listAllveggie", ItemRegistry.radishItem);
        oreDictHelper.removeItemFromOreDict("listAllveggie", ItemRegistry.rhubarbItem);
        oreDictHelper.removeItemFromOreDict("listAllveggie", ItemRegistry.rutabagaItem);
        oreDictHelper.removeItemFromOreDict("listAllveggie", ItemRegistry.seaweedItem);
        oreDictHelper.removeItemFromOreDict("listAllveggie", ItemRegistry.soybeanItem);
        oreDictHelper.removeItemFromOreDict("listAllveggie", ItemRegistry.spinachItem);
        oreDictHelper.removeItemFromOreDict("listAllveggie", ItemRegistry.sweetpotatoItem);
        oreDictHelper.removeItemFromOreDict("listAllveggie", ItemRegistry.whitemushroomItem);
        oreDictHelper.removeItemFromOreDict("listAllveggie", ItemRegistry.wintersquashItem);

        oreDictHelper.removeItemFromOreDict("listAllspice", ItemRegistry.mustardseedsItem);
        oreDictHelper.removeItemFromOreDict("listAllspice", ItemRegistry.gingerItem);

        oreDictHelper.removeItemFromOreDict("listAllsmoothie", ItemRegistry.bananasmoothieItem);
        oreDictHelper.removeItemFromOreDict("listAllsmoothie", ItemRegistry.cherrysmoothieItem);
        oreDictHelper.removeItemFromOreDict("listAllsmoothie", ItemRegistry.kiwismoothieItem);
        oreDictHelper.removeItemFromOreDict("listAllsmoothie", ItemRegistry.lemonsmoothieItem);
        oreDictHelper.removeItemFromOreDict("listAllsmoothie", ItemRegistry.limesmoothieItem);
        oreDictHelper.removeItemFromOreDict("listAllsmoothie", ItemRegistry.mangosmoothieItem);
        oreDictHelper.removeItemFromOreDict("listAllsmoothie", ItemRegistry.orangesmoothieItem);
        oreDictHelper.removeItemFromOreDict("listAllsmoothie", ItemRegistry.papayasmoothieItem);
        oreDictHelper.removeItemFromOreDict("listAllsmoothie", ItemRegistry.peachsmoothieItem);
        oreDictHelper.removeItemFromOreDict("listAllsmoothie", ItemRegistry.pomegranatesmoothieItem);
        oreDictHelper.removeItemFromOreDict("listAllsmoothie", ItemRegistry.starfruitsmoothieItem);
        oreDictHelper.removeItemFromOreDict("listAllsmoothie", ItemRegistry.strawberrysmoothieItem);

        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.bambooshootseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.barleyseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.beanseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.beetseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.bellpepperseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.blackberryseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.blueberryseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.cactusfruitseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.cantaloupeseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.cauliflowerseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.celeryseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.chilipepperseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.coffeeseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.cornseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.cranberryseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.garlicseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.gingerseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.grapeseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.kiwiseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.leekseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.lettuceseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.mustardseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.oatsseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.onionseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.peanutseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.pineappleseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.radishseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.raspberryseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.rhubarbseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.ryeseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.seaweedseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.soybeanseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.spinachseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.strawberryseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.sweetpotatoseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.teaseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.whitemushroomseedItem);
        oreDictHelper.removeItemFromOreDict("listAllseed", ItemRegistry.wintersquashseedItem);

        oreDictHelper.removeItemFromOreDict("listAllrootveggie", ItemRegistry.radishItem);
        oreDictHelper.removeItemFromOreDict("listAllrootveggie", ItemRegistry.rutabagaItem);
        oreDictHelper.removeItemFromOreDict("listAllrootveggie", ItemRegistry.sweetpotatoItem);

        oreDictHelper.removeItemFromOreDict("listAllmushroom", ItemRegistry.whitemushroomItem);

        oreDictHelper.removeItemFromOreDict("listAlljuice", ItemRegistry.cactusfruitjuiceItem);
        oreDictHelper.removeItemFromOreDict("listAlljuice", ItemRegistry.cherryjuiceItem);
        oreDictHelper.removeItemFromOreDict("listAlljuice", ItemRegistry.cranberryjuiceItem);
        oreDictHelper.removeItemFromOreDict("listAlljuice", ItemRegistry.grapejuiceItem);
        oreDictHelper.removeItemFromOreDict("listAlljuice", ItemRegistry.kiwijuiceItem);
        oreDictHelper.removeItemFromOreDict("listAlljuice", ItemRegistry.lemonaideItem);
        oreDictHelper.removeItemFromOreDict("listAlljuice", ItemRegistry.limejuiceItem);
        oreDictHelper.removeItemFromOreDict("listAlljuice", ItemRegistry.mangojuiceItem);
        oreDictHelper.removeItemFromOreDict("listAlljuice", ItemRegistry.orangejuiceItem);
        oreDictHelper.removeItemFromOreDict("listAlljuice", ItemRegistry.papayajuiceItem);
        oreDictHelper.removeItemFromOreDict("listAlljuice", ItemRegistry.peachjuiceItem);
        oreDictHelper.removeItemFromOreDict("listAlljuice", ItemRegistry.pomegranatejuiceItem);
        oreDictHelper.removeItemFromOreDict("listAlljuice", ItemRegistry.starfruitjuiceItem);
        oreDictHelper.removeItemFromOreDict("listAlljuice", ItemRegistry.strawberryjuiceItem);

        oreDictHelper.removeItemFromOreDict("listAllgreenveggie", ItemRegistry.artichokeItem);
        oreDictHelper.removeItemFromOreDict("listAllgreenveggie", ItemRegistry.brusselsproutItem);
        oreDictHelper.removeItemFromOreDict("listAllgreenveggie", ItemRegistry.celeryItem);
        oreDictHelper.removeItemFromOreDict("listAllgreenveggie", ItemRegistry.lettuceItem);
        oreDictHelper.removeItemFromOreDict("listAllgreenveggie", ItemRegistry.okraItem);
        oreDictHelper.removeItemFromOreDict("listAllgreenveggie", ItemRegistry.seaweedItem);
        oreDictHelper.removeItemFromOreDict("listAllgreenveggie", ItemRegistry.spinachItem);

        oreDictHelper.removeItemFromOreDict("listAllgrain", ItemRegistry.barleyItem);
        oreDictHelper.removeItemFromOreDict("listAllgrain", ItemRegistry.oatsItem);
        oreDictHelper.removeItemFromOreDict("listAllgrain", ItemRegistry.ryeItem);

        oreDictHelper.removeItemFromOreDict("listAllfruit", ItemRegistry.apricotItem);
        oreDictHelper.removeItemFromOreDict("listAllfruit", ItemRegistry.bananaItem);
        oreDictHelper.removeItemFromOreDict("listAllfruit", ItemRegistry.blackberryItem);
        oreDictHelper.removeItemFromOreDict("listAllfruit", ItemRegistry.blueberryItem);
        oreDictHelper.removeItemFromOreDict("listAllfruit", ItemRegistry.cactusfruitItem);
        oreDictHelper.removeItemFromOreDict("listAllfruit", ItemRegistry.cantaloupeItem);
        oreDictHelper.removeItemFromOreDict("listAllfruit", ItemRegistry.cherryItem);
        oreDictHelper.removeItemFromOreDict("listAllfruit", ItemRegistry.cranberryItem);
        oreDictHelper.removeItemFromOreDict("listAllfruit", ItemRegistry.dragonfruitItem);
        oreDictHelper.removeItemFromOreDict("listAllfruit", ItemRegistry.figItem);
        oreDictHelper.removeItemFromOreDict("listAllfruit", ItemRegistry.grapefruitItem);
        oreDictHelper.removeItemFromOreDict("listAllfruit", ItemRegistry.grapeItem);
        oreDictHelper.removeItemFromOreDict("listAllfruit", ItemRegistry.kiwiItem);
        oreDictHelper.removeItemFromOreDict("listAllfruit", ItemRegistry.lemonItem);
        oreDictHelper.removeItemFromOreDict("listAllfruit", ItemRegistry.limeItem);
        oreDictHelper.removeItemFromOreDict("listAllfruit", ItemRegistry.mangoItem);
        oreDictHelper.removeItemFromOreDict("listAllfruit", ItemRegistry.orangeItem);
        oreDictHelper.removeItemFromOreDict("listAllfruit", ItemRegistry.papayaItem);
        oreDictHelper.removeItemFromOreDict("listAllfruit", ItemRegistry.peachItem);
        oreDictHelper.removeItemFromOreDict("listAllfruit", ItemRegistry.pearItem);
        oreDictHelper.removeItemFromOreDict("listAllfruit", ItemRegistry.pineappleItem);
        oreDictHelper.removeItemFromOreDict("listAllfruit", ItemRegistry.plumItem);
        oreDictHelper.removeItemFromOreDict("listAllfruit", ItemRegistry.pomegranateItem);
        oreDictHelper.removeItemFromOreDict("listAllfruit", ItemRegistry.raspberryItem);
        oreDictHelper.removeItemFromOreDict("listAllfruit", ItemRegistry.starfruitItem);
        oreDictHelper.removeItemFromOreDict("listAllfruit", ItemRegistry.strawberryItem);

        oreDictHelper.removeItemFromOreDict("listAllnut", ItemRegistry.cashewItem);
        oreDictHelper.removeItemFromOreDict("listAllnut", ItemRegistry.peanutItem);
        oreDictHelper.removeItemFromOreDict("listAllnut", ItemRegistry.pecanItem);
        oreDictHelper.removeItemFromOreDict("listAllnut", ItemRegistry.walnutItem);

        oreDictHelper.removeItemFromOreDict("cropBlackberry", ItemRegistry.blackberryItem);

        oreDictHelper.removeItemFromOreDict("cropBlueberry", ItemRegistry.blueberryItem);

        oreDictHelper.removeItemFromOreDict("cropRaspberry", ItemRegistry.raspberryItem);

    }

}
