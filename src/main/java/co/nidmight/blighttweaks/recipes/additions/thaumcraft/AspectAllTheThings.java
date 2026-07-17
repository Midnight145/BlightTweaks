package co.nidmight.blighttweaks.recipes.additions.thaumcraft;

import co.nidmight.blighttweaks.recipes.helpers.IGameEditor;
import co.nidmight.blighttweaks.recipes.helpers.RecipeEditorUtil;
import co.nidmight.blighttweaks.recipes.helpers.ThaumcraftEditorUtil;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ThaumcraftApiHelper;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public class AspectAllTheThings implements IGameEditor {
    private static AspectList parseAspectList(String aspectListString) {
        String[] aspectEntries = aspectListString.split(",");
        AspectList aspectList = new AspectList();
        for (String entry : aspectEntries) {
            entry = entry.trim();
            String[] split = entry.split(" ");
            if (split.length != 2) {
                throw new IllegalArgumentException(
                    "Invalid aspect entry: " + entry + ". Expected format: <aspect> <amount>");
            }
            String aspectName = split[0];
            int amount;
            try {
                amount = Integer.parseInt(split[1]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(
                    "Invalid amount for aspect " + aspectName + ": " + split[1], e);
            }
            aspectList.add(Aspect.getAspect(aspectName), amount);
        }
        return aspectList;
    }

    private void set(String itemStackString, String aspectListString) {
        ThaumcraftEditorUtil.setItemAspects(RecipeEditorUtil.parseItemStack(itemStackString), parseAspectList(aspectListString));
    }

    private void remove(String itemStackString, String aspectListString) {
        ItemStack stack = RecipeEditorUtil.parseItemStack(itemStackString);
        AspectList aspectsToRemove = parseAspectList(aspectListString);
        AspectList currentAspects = new AspectList(stack);
        for (Aspect aspect : aspectsToRemove.getAspects()) {
            currentAspects.reduce(aspect, aspectsToRemove.getAmount(aspect));
        }
        ThaumcraftEditorUtil.setItemAspects(stack, currentAspects);
    }


    @Override
    public void apply() {
        // Aspects with an amount of 0
        set("<minecraft:redstone_torch>", "potentia 1, machina 1");
        set("<minecraft:sticky_piston>", "limus 1, machina 1, motus 1");
        set("<minecraft:stone_pressure_plate>", "terra 3, machina 1, sensus 1");
        set("<Thaumcraft:WandCasting>", "metallum 4, praecantatio 1, instrumentum 1");
        set("<MineFactoryReloaded:glass.helm>", "ordo 4, fabrico 2, ignis 2, tutamen 1");
        set("<betterstorage:cardboardSword>", "fabrico 1, telum 1");


        // Harvestcraft Aspect Fixes

// Jellies
        set("<harvestcraft:applejellyItem>", "fames 2");
        set("<harvestcraft:blackberryjellyItem>", "fames 2");
        set("<harvestcraft:blueberryjellyItem>", "fames 2");
        set("<harvestcraft:raspberryjellyItem>", "fames 2");
        set("<harvestcraft:watermelonjellyItem>", "fames 2");

// Smoothies
        set("<harvestcraft:blackberrysmoothieItem>", "gelum 1, victus 1");
        set("<harvestcraft:blueberrysmoothieItem>", "gelum 1, victus 1");
        set("<harvestcraft:melonsmoothieItem>", "gelum 1, victus 1");
        set("<harvestcraft:raspberrysmoothieItem>", "gelum 1, victus 1");

// Yogurts
        set("<harvestcraft:appleyogurtItem>", "sano 2, fames 2");
        set("<harvestcraft:blackberryyogurtItem>", "sano 2, fames 2");
        set("<harvestcraft:blueberryyogurtItem>", "sano 2, fames 2");
        set("<harvestcraft:melonyogurtItem>", "sano 2, fames 2");
        set("<harvestcraft:plainyogurtItem>", "sano 2, fames 2");
        set("<harvestcraft:pumpkinyogurtItem>", "sano 2, fames 2");
        set("<harvestcraft:raspberryyogurtItem>", "sano 2, fames 2");

// Juices
        set("<harvestcraft:applejuiceItem>", "aqua 1, victus 1");
        set("<harvestcraft:blackberryjuiceItem>", "aqua 1, victus 1");
        set("<harvestcraft:blueberryjuiceItem>", "aqua 1, victus 1");
        set("<harvestcraft:carrotjuiceItem>", "aqua 1, messis 1");
        set("<harvestcraft:melonjuiceItem>", "aqua 1, fames 1");
        set("<harvestcraft:raspberryjuiceItem>", "aqua 1, victus 1");

// Veggie (Heavy Cream) Soups
        set("<harvestcraft:carrotsoupItem>", "messis 1, sano 1");
        set("<harvestcraft:cucumbersoupItem>", "messis 1, sano 1");
        set("<harvestcraft:pumpkinsoupItem>", "messis 1, sano 1");

// Only Stock Soups
        set("<harvestcraft:cactussoupItem>", "messis 1");
        set("<harvestcraft:gardensoupItem>", "messis 2");
        set("<harvestcraft:potatosoupItem>", "fames 1, messis 2");
        set("<harvestcraft:seedsoupItem>", "messis 2");
        set("<harvestcraft:vegetablesoupItem>", "messis 2");
        set("<harvestcraft:tomatosoupItem>", "messis 2");

// Complex Soups
        set("<harvestcraft:creamedbroccolisoupItem>", "messis 3");
        set("<harvestcraft:splitpeasoupItem>", "corpus 2, messis 1");
        set("<harvestcraft:chickennoodlesoupItem>", "corpus 2, messis 2, fames 1, sano 1");
        set("<harvestcraft:turnipsoupItem>", "messis 2, gula 1");

// Potatoes
        set("<harvestcraft:scallionbakedpotatoItem>", "sano 1, messis 1");
        set("<harvestcraft:butteredpotatoItem>", "sano 1, messis 1");
        set("<harvestcraft:loadedbakedpotatoItem>", "sano 2, messis 1, corpus 1");
        set("<harvestcraft:mashedpotatoesItem>", "sano 2, messis 1");

// -=- Dough-based foods -=-
        set("<harvestcraft:doughItem>", "aqua 1, messis 1, fames 1");

// Fruit Pies
        set("<harvestcraft:applepieItem>", "aqua 2, messis 1, fames 1");
        set("<harvestcraft:blueberrypieItem>", "aqua 2, messis 1, fames 1");
        set("<harvestcraft:raspberrypieItem>", "aqua 2, messis 1, fames 1");
        set("<harvestcraft:blackberrycobblerItem>", "aqua 2, messis 1, fames 1");

// Cakes
        set("<harvestcraft:cheesecakeItem>", "aqua 1, messis 1, fames 1, sano 1");
        set("<harvestcraft:pumpkincheesecakeItem>", "aqua 1, messis 2, fames 1, sano 1");
        set("<harvestcraft:carrotcakeItem>", "aqua 1, messis 2, fames 1");
        set("<harvestcraft:redvelvetcakeItem>", "messis 1, fames 2, sensus 2, sano 2");

// Pasta
        set("<harvestcraft:pastaItem>", "messis 1, fames 1, sano 1");
        set("<harvestcraft:spagettiItem>", "messis 2, fames 1, sano 1");
        set("<harvestcraft:spagettiandmeatballsItem>", "messis 2, fames 1, sano 1, corpus 1");
        set("<harvestcraft:broccolimacItem>", "messis 2, sano 2, fames 2");
        set("<harvestcraft:eggplantparmItem>", "messis 3, sano 2, fames 2");

// Donuts
        set("<harvestcraft:donutItem>", "messis 1, fames 1");
        set("<harvestcraft:frosteddonutItem>", "aqua 1, messis 1, fames 2, sensus 2");
        set("<harvestcraft:powdereddonutItem>", "messis 1, fames 3");

// Other baked goods
        set("<harvestcraft:pancakesItem>", "messis 1, sano 1");
        set("<harvestcraft:blueberrypancakesItem>", "messis 1, sano 1");
        set("<harvestcraft:wafflesItem>", "aqua 1, messis 1, sano 2");
        set("<harvestcraft:datenutbreadItem>", "messis 2, fames 1");
        set("<harvestcraft:softpretzelItem>", "aqua 1, messis 1, fames 1");
        set("<harvestcraft:pumpkinbreadItem>", "messis 2, fames 2");
        set("<harvestcraft:lavendershortbreadItem>", "messis 1, fames 1, sensus 1");
        set("<harvestcraft:potatoandcheesepirogiItem>", "messis 2, fames 2, sano 1");
        set("<harvestcraft:fairybreadItem>", "messis 1, fames 2, sensus 2");
        set("<harvestcraft:damperItem>", "aqua 1, sano 1, messis 1, fames 1");

// Burgers
        set("<harvestcraft:cheeseburgerItem>", "messis 1, corpus 1, sano 1, fames 1");
        set("<harvestcraft:baconmushroomburgerItem>", "messis 1, corpus 2, sano 1, fames 2");
        set("<harvestcraft:baconcheeseburgerItem>", "messis 1, corpus 2, sano 1, fames 1");

// Other known issues:
        set("<harvestcraft:cheeseItem>", "aqua 1, sano 1, fames 1");
        set("<harvestcraft:toastItem>", "fames 2, messis 3, ignis 1");
        set("<harvestcraft:grilledcheeseItem>", "fames 3, messis 2, ignis 1, gula 1, sano 1");
        set("<harvestcraft:taffyItem>", "aqua 1, fames 1");
        set("<harvestcraft:butterItem>", "gula 2");
        set("<harvestcraft:heavycreamItem>", "fames 1, sano 1");

        set("<harvestcraft:stuffedmushroomItem>", "aqua 1, sano 1, fames 2");
        set("<harvestcraft:steamedpeasItem>", "aqua 1, messis 1");

        remove("<harvestcraft:mincepieItem>", "metallum 6");
        remove("<harvestcraft:vegemiteItem>", "metallum 6");

        set("<harvestcraft:icecreamItem>", "sano 1, gelum 1");
        set("<harvestcraft:caramelicecreamItem>", "sano 1, gelum 1");

        set("<harvestcraft:herbbutterparsnipsItem>", "messis 1, gula 1");
        set("<harvestcraft:chickenparmasanItem>", "corpus 2, sano 1, messis 1");
        set("<harvestcraft:bakedturnipsItem>", "messis 1, gula 1");
        set("<harvestcraft:zucchinifriesItem>", "messis 1, sano 1");
        set("<harvestcraft:pizzaItem>", "corpus 2, sano 1, messis 2, fames 1");
        set("<harvestcraft:chickenpotpieItem>", "corpus 2, messis 3, fames 1");
        set("<harvestcraft:glazedcarrotsItem>", "messis 1, gula 1, fames 1");
        set("<harvestcraft:marshmellowsItem>", "aqua 3");


// Blood Magic
        set("<AWWayofTime:blankSlate>",                   "terra 2, victus 1");
        set("<AWWayofTime:reinforcedSlate>",              "terra 2, victus 2, tutamen 1");
        set("<AWWayofTime:imbuedSlate>",                  "terra 2, victus 4, praecantatio 4");
        set("<AWWayofTime:demonicSlate>",                 "terra 2, victus 8, praecantatio 4, infernus 4, ignis 4");
        set("<AWWayofTime:bloodMagicBaseItems:27>",       "terra 3, victus 15, praecantatio 10, alienis 8, aer 8, spiritus 8");

        set("<AWWayofTime:waterSigil>", "aqua 8, praecantatio 2");
        set("<AWWayofTime:lavaSigil>", "ignis 8, praecantatio 2");
        set("<AWWayofTime:voidSigil>", "vacuos 8, praecantatio 4");
        set("<AWWayofTime:airSigil>", "volatus 8, aer 4, praecantatio 2");
        set("<AWWayofTime:sigilOfTheFastMiner>", "perfodio 8, terra 4, praecantatio 4");
        set("<AWWayofTime:sigilOfElementalAffinity>", "tutamen 8, ignis 4, aqua 4, aer 4, praecantatio 6");
        set("<AWWayofTime:sigilOfHaste>", "motus 8, praecantatio 3");
        set("<AWWayofTime:sigilOfHolding>", "vacuos 8, praecantatio 8");
        set("<AWWayofTime:divinationSigil>", "sensus 8, praecantatio 2");
        set("<AWWayofTime:growthSigil>", "herba 8, victus 4, praecantatio 4");
        set("<AWWayofTime:sigilOfWind>", "tempestas 8, tutamen 4, praecantatio 8");
        set("<AWWayofTime:sigilOfTheBridge>", "iter 8, praecantatio 6");
        set("<AWWayofTime:sigilOfMagnetism>", "metallum 8, lucrum 4, iter 4, praecantatio 6");
        set("<AWWayofTime:itemBloodLightSigil>", "lux 8, praecantatio 6");
        set("<AWWayofTime:sigilOfSupression>", "vacuos 12, praecantatio 8");
        set("<AWWayofTime:sigilOfEnderSeverance>", "alienis 8, vinculum 8, praecantatio 8");
        set("<AWWayofTime:seerSigil>", "sensus 12, praecantatio 4");
        set("<AWWayofTime:itemHarvestSigil>", "meto 10, praecantatio 10");
        set("<AWWayofTime:itemCompressionSigil>", "fabrico 8, praecantatio 8");
        set("<blighttweaks:soulSigil>", "tutamen 16, praecantatio 12");

        set("<AWWayofTime:weakBloodShard>", "spiritus 2, praecantatio 1, vitreus 1");
        set("<ForbiddenMagic:FMResource:3>", "spiritus 1, vitium 2, praecantatio 1");

        set("<AWWayofTime:simpleCatalyst>",               "potentia 3");
        set("<AWWayofTime:bloodMagicBaseAlchemyItems:3>", "potentia 6");
        set("<AWWayofTime:bloodMagicBaseAlchemyItems:4>", "potentia 9");

        set("<AWWayofTime:mundanePowerCatalyst>",         "potentia 6, perditio 3");
        set("<AWWayofTime:averagePowerCatalyst>",         "potentia 15, perditio 6");
        set("<AWWayofTime:greaterPowerCatalyst>",         "potentia 25, perditio 10");

        set("<AWWayofTime:mundaneLengtheningCatalyst>",   "potentia 2, ordo 3");
        set("<AWWayofTime:averageLengtheningCatalyst>",   "potentia 2, ordo 6");
        set("<AWWayofTime:greaterLengtheningCatalyst>",   "potentia 2, ordo 10");

        set("<AWWayofTime:weakFillingAgent>",             "aqua 2, terra 2, ignis 2, aer 2");
        set("<AWWayofTime:standardFillingAgent>",         "aqua 3, terra 3, ignis 3, aer 3");
        set("<AWWayofTime:enhancedFillingAgent>",         "aqua 5, terra 5, ignis 5, aer 5");

        set("<AWWayofTime:weakBindingAgent>",             "potentia 3, vinculum 2, praecantatio 1");
        set("<AWWayofTime:standardBindingAgent>",         "potentia 6, vinculum 6, praecantatio 6");

        set("<AWWayofTime:bloodMagicBaseAlchemyItems>",   "potentia 6, telum 9");
        set("<AWWayofTime:bloodMagicBaseAlchemyItems:1>", "potentia 6, tutamen 9");
        set("<AWWayofTime:bloodMagicBaseAlchemyItems:2>", "potentia 6, telum 9");
        set("<AWWayofTime:bloodMagicBaseAlchemyItems:6>", "potentia 6, telum 9");
        set("<AWWayofTime:bloodMagicBaseAlchemyItems:7>", "potentia 6, telum 9");
        set("<AWWayofTime:bloodMagicBaseAlchemyItems:8>", "potentia 6, telum 9");

        set("<AWWayofTime:bloodMagicBaseAlchemyItems:5>", "mortuus 2, perditio 1");

//Metals seem to have three metallum plus one something else. (Gold has two)
        set("<Metallurgy:manganese.ingot>", "metallum 3, terra 1");
        set("<Metallurgy:hepatizon.ingot>", "metallum 2, lucrum 3");
        set("<Metallurgy:damascus.steel.ingot>", "metallum 3, instrumentum 2, lucrum 1");
        set("<Metallurgy:angmallen.ingot>", "metallum 3, lucrum 1");
        set("<Metallurgy:eximite.ingot>", "metallum 3, alienis 1");
        set("<Metallurgy:meutoite.ingot>", "alienis 2, terra 1, metallum 1");
        set("<Metallurgy:desichalkos.ingot>", "metallum 3, alienis 1, instrumentum 1, terra 1");
        set("<Metallurgy:prometheum.ingot>", "metallum 3, herba 1");
        set("<Metallurgy:deep.iron.ingot>", "metallum 3, terra 1");
        set("<Metallurgy:infuscolium.ingot>", "metallum 3, praecantatio 1");
        set("<Metallurgy:black.steel.ingot>", "metallum 3, tenebrae 1, terra 1");
        set("<Metallurgy:oureclase.ingot>", "metallum 3, tutamen 1");
        set("<Metallurgy:astral.silver.ingot>", "metallum 3, lucrum 1, auram 1");
        set("<Metallurgy:carmot.ingot>", "metallum 3, praecantatio 1, aer 1");
        set("<ThermalFoundation:material:70>", "metallum 3, volatus 1");
        set("<Metallurgy:rubracium.ingot>", "metallum 3, spiritus 1");
        set("<Metallurgy:quicksilver.ingot>", "metallum 3, motus 1, volatus 1");
        set("<Metallurgy:haderoth.ingot>", "metallum 3, tutamen 1, aer 1");
        set("<Metallurgy:orichalcum.ingot>", "metallum 3, vitreus 1, tutamen 1");
        set("<Metallurgy:celenegil.ingot>", "metallum 3, vitreus 1, praecantatio 2");
        set("<Metallurgy:adamantine.ingot>", "metallum 3, tutamen 2, terra 1");
        set("<Metallurgy:atlarus.ingot>", "metallum 3, tutamen 1, auram 1");
        set("<Metallurgy:tartarite.ingot>", "metallum 3, tutamen 2, auram 2, praecantatio 2");
        set("<Metallurgy:ignatius.ingot>", "metallum 2, ignis 2");
        set("<Metallurgy:shadow.iron.ingot>", "metallum 2, perditio 2");
        set("<Metallurgy:lemurite.ingot>", "metallum 2, infernus 1");
        set("<Metallurgy:midasium.ingot>", "metallum 3, lucrum 2");
        set("<Metallurgy:vyroxeres.ingot>", "metallum 3, venenum 1");
        set("<Metallurgy:ceruclase.ingot>", "metallum 3, gelum 1");
        set("<Metallurgy:alduorite.ingot>", "metallum 2, vinculum 1");
        set("<Metallurgy:kalendrite.ingot>", "metallum 3, sano 2");
        set("<Metallurgy:vulcanite.ingot>", "metallum 3, ignis 2, perditio 1, superbia 1");
        set("<Metallurgy:shadow.steel.ingot>", "metallum 3, perditio 1");
        set("<Metallurgy:inolashite.ingot>", "metallum 3, venenum 2, vinculum 1");
        set("<Metallurgy:amordrine.ingot>", "metallum 3, sano 2, praecantatio 2");
        set("<Metallurgy:sanguinite.ingot>", "metallum 3, infernus 2, venenum 1, superbia 2");

//It seems 3 turns into 20, 2 turns into 13, and 1 turns into 6
        set("<Metallurgy:base.block:2>", "metallum 20, terra 6");
        set("<Metallurgy:base.block:4>", "metallum 13, lucrum 20");
        set("<Metallurgy:base.block:5>", "metallum 20, instrumentum 13, lucrum 6");
        set("<Metallurgy:base.block:6>", "metallum 20, lucrum 6");
        set("<Metallurgy:ender.block:0>", "metallum 20, alienis 6");
        set("<Metallurgy:ender.block:1>", "alienis 13, terra 6, metallum 6");
        set("<Metallurgy:ender.block:2>", "metallum 20, alienis 6, instrumentum 6, terra 6");
        set("<Metallurgy:fantasy.block:0>", "metallum 20, herba 6");
        set("<Metallurgy:fantasy.block:1>", "metallum 20, terra 6");
        set("<Metallurgy:fantasy.block:2>", "metallum 20, praecantatio 6");
        set("<Metallurgy:fantasy.block:3>", "metallum 20, tenebrae 6, terra 6");
        set("<Metallurgy:fantasy.block:4>", "metallum 20, tutamen 6");
        set("<Metallurgy:fantasy.block:5>", "metallum 20, lucrum 6, auram 6");
        set("<Metallurgy:fantasy.block:6>", "metallum 20, praecantatio 6, aer 6");
        set("<Metallurgy:fantasy.block:8>", "metallum 20, spiritus 6");
        set("<Metallurgy:fantasy.block:9>", "metallum 20, motus 6, volatus 6");
        set("<Metallurgy:fantasy.block:10>", "metallum 20, tutamen 6, aer 6");
        set("<Metallurgy:fantasy.block:11>", "metallum 20, vitreus 6, tutamen 6");
        set("<Metallurgy:fantasy.block:12>", "metallum 20, vitreus 6, praecantatio 13");
        set("<Metallurgy:fantasy.block:13>", "metallum 20, tutamen 13, terra 6");
        set("<Metallurgy:fantasy.block:14>", "metallum 20, tutamen 6, auram 6");
        set("<Metallurgy:fantasy.block:15>", "metallum 20, tutamen 13, auram 13, praecantatio 13");
        set("<Metallurgy:nether.block:1>", "metallum 13, perditio 13");
        set("<Metallurgy:nether.block:2>", "metallum 13, infernus 6");
        set("<Metallurgy:nether.block:3>", "metallum 20, lucrum 13");
        set("<Metallurgy:nether.block:4>", "metallum 20, venenum 6");
        set("<Metallurgy:nether.block:5>", "metallum 20, gelum 6");
        set("<Metallurgy:nether.block:6>", "metallum 13, vinculum 6");
        set("<Metallurgy:nether.block:7>", "metallum 20, sano 13");
        set("<Metallurgy:nether.block:8>", "metallum 20, ignis 13, perditio 6, superbia 6");
        set("<Metallurgy:nether.block:9>", "metallum 20, perditio 6");
        set("<Metallurgy:nether.block:10>", "metallum 20, venenum 13, vinculum 6");
        set("<Metallurgy:nether.block:11>", "metallum 20, sano 13, praecantatio 13");
        set("<Metallurgy:nether.block:12>", "metallum 20, infernus 13, venenum 6, superbia 13");

        set("<Metallurgy:zinc.ingot>", "metallum 2, perditio 1");
        set("<Metallurgy:brass.ingot>", "metallum 3, machina 1, perditio 1");
        set("<RedstoneArsenal:material:32>", "metallum 3, machina 2, lucrum 1"); //Fluxed Electrum
        set("<TConstruct:materials:3>", "metallum 3, motus 2"); //Cobalt
        set("<ExtraTiC:drulloyIngot>", "metallum 3, perditio 3"); //What is this even?
        set("<ExtraTiC:funStuffIngot>", "metallum 3, lux 2, desidia 2"); //Fairy
        set("<ExtraTiC:funStuffIngot:1>", "metallum 3, cogitio 2, desidia 2"); //Pokefenium
        set("<ExtraTiC:funStuffIngot:2>", "metallum 3, perditio 1"); //Redauram
        set("<TConstruct:materials:4>", "metallum 3, terra 2, ignis 2"); //Ardite
        set("<TConstruct:materials:5>", "metallum 3, motus 1, terra 1, ignis 1, tutamen 1"); //Manyulyn
        set("<TConstruct:materials:11>", "metallum 3, machina 1"); //Aluminum
        set("<TConstruct:materials:14>", "metallum 3, machina 2"); //Aluminum Brass
        set("<TConstruct:materials:15>", "metallum 3, instrumentum 2"); //Alumite
        set("<TConstruct:materials:18>", "metallum 3, tenebrae 1"); //Obsidian
        set("<TConstruct:materials:34>", "metallum 3, corpus 2"); //Pig Iron

        set("<ThermalFoundation:material:74>", "metallum 3, motus 1, tutamen 1, machina 1"); //Signalum
        set("<ThermalFoundation:material:71>", "metallum 3, lucrum 1"); //Electrum
        set("<ThermalFoundation:material:75>", "metallum 3, machina 1, lux 2"); //Lumium
        set("<ThermalFoundation:material:76>", "metallum 3, alienis 2, lucrum 2, potentia 1"); //Enderium
        set("<ThermalFoundation:material:72>", "metallum 3, machina 1, ordo 1"); //Invar
        set("<ThermalFoundation:material:68>", "metallum 1, machina 1, ordo 2"); //Nickel
        set("<BigReactors:BRIngot:3>", "metallum 1, potentia 2, venenum 1, permutatio 2"); //Blutonium

// Give all metal nuggets 1 metallum
        set("<Thaumcraft:ItemNugget>", "metallum 1");
        set("<Thaumcraft:ItemNugget:7>", "metallum 1");
        set("<ThermalFoundation:material:96>", "metallum 1");
        set("<ThermalFoundation:material:97>", "metallum 1");
        set("<ThermalFoundation:material:99>", "metallum 1");
        set("<Botania:manaResource:17>", "metallum 1");
        set("<Botania:manaResource:18>", "metallum 1");
        set("<Botania:manaResource:19>", "metallum 1");
        set("<Metallurgy:ender.nugget:*>", "metallum 1");
        set("<Metallurgy:ender.nugget:1>", "metallum 1");
        set("<Metallurgy:ender.nugget:2>", "metallum 1");
        set("<Metallurgy:nether.nugget:0>", "metallum 1");
        set("<Metallurgy:nether.nugget:1>", "metallum 1");
        set("<Metallurgy:nether.nugget:2>", "metallum 1");
        set("<Metallurgy:nether.nugget:3>", "metallum 1");
        set("<Metallurgy:nether.nugget:4>", "metallum 1");
        set("<Metallurgy:nether.nugget:5>", "metallum 1");
        set("<Metallurgy:nether.nugget:6>", "metallum 1");
        set("<Metallurgy:nether.nugget:7>", "metallum 1");
        set("<Metallurgy:nether.nugget:8>", "metallum 1");
        set("<Metallurgy:nether.nugget:9>", "metallum 1");
        set("<Metallurgy:nether.nugget:10>", "metallum 1");
        set("<Metallurgy:nether.nugget:11>", "metallum 1");
        set("<Metallurgy:nether.nugget:12>", "metallum 1");
        set("<Metallurgy:precious.nugget:0>", "metallum 1");
        set("<Metallurgy:precious.nugget:1>", "metallum 1");
        set("<Metallurgy:precious.nugget:2>", "metallum 1");
        set("<Metallurgy:precious.nugget:3>", "metallum 1");
        set("<Metallurgy:precious.nugget:4>", "metallum 1");
        set("<Metallurgy:fantasy.nugget:0>", "metallum 1");
        set("<Metallurgy:fantasy.nugget:1>", "metallum 1");
        set("<Metallurgy:fantasy.nugget:2>", "metallum 1");
        set("<Metallurgy:fantasy.nugget:3>", "metallum 1");
        set("<Metallurgy:fantasy.nugget:4>", "metallum 1");
        set("<Metallurgy:fantasy.nugget:5>", "metallum 1");
        set("<Metallurgy:fantasy.nugget:6>", "metallum 1");
        set("<Metallurgy:fantasy.nugget:7>", "metallum 1");
        set("<Metallurgy:fantasy.nugget:8>", "metallum 1");
        set("<Metallurgy:fantasy.nugget:9>", "metallum 1");
        set("<Metallurgy:fantasy.nugget:10>", "metallum 1");
        set("<Metallurgy:fantasy.nugget:11>", "metallum 1");
        set("<Metallurgy:fantasy.nugget:12>", "metallum 1");
        set("<Metallurgy:fantasy.nugget:13>", "metallum 1");
        set("<Metallurgy:fantasy.nugget:14>", "metallum 1");
        set("<Metallurgy:fantasy.nugget:15>", "metallum 1");
        set("<Metallurgy:base.nugget:2>", "metallum 1");
        set("<Metallurgy:base.nugget:3>", "metallum 1");
        set("<Metallurgy:base.nugget:4>", "metallum 1");
        set("<Metallurgy:base.nugget:5>", "metallum 1");
        set("<Metallurgy:base.nugget:6>", "metallum 1");
        set("<Metallurgy:base.nugget:7>", "metallum 1");
        set("<RedstoneArsenal:material:64>", "metallum 1");
        set("<TConstruct:oreBerries:1>", "metallum 1");
        set("<TConstruct:oreBerries:4>", "metallum 1");
        set("<TConstruct:materials:22>", "metallum 1");
        set("<TConstruct:materials:24>", "metallum 1");
        set("<TConstruct:materials:27>", "metallum 1");
        set("<TConstruct:materials:28>", "metallum 1");
        set("<TConstruct:materials:29>", "metallum 1");
        set("<TConstruct:materials:30>", "metallum 1");
        set("<TConstruct:materials:31>", "metallum 1");
        set("<TConstruct:materials:32>", "metallum 1");

        set("<TConstruct:materials:35>", "corpus 1"); // Pig Iron Platter

        set("<TConstruct:materials:2>", "terra 2, ignis 1"); //Seared Brick
        set("<TConstruct:materials:37>", "terra 1, ignis 2"); //Seared Nether brick

        set("<TConstruct:Smeltery:4>", "terra 3, ignis 2"); //Seared Nether brick
        set("<TConstruct:Smeltery:5>", "terra 2, ignis 1, perditio 2"); //Seared Nether brick
        set("<TConstruct:Smeltery:6>", "terra 3, ignis 2"); //Seared Nether brick

        set("<TConstruct:decoration.stonetorch>", "lux 1");

        set("<minecraft:milk_bucket>", "sano 2, aqua 2, fames 2");

        set("<ThermalFoundation:Storage:12>", "metallum 20, alienis 13, lucrum 13, potentia 7"); //Enderium
        set("<ThermalFoundation:Storage:10>", "metallum 20, motus 7, tutamen 7, machina 7"); //Signalum
        set("<ThermalFoundation:Storage:11>", "metallum 20, machina 7, lux 13"); //Lumium
        set("<ThermalFoundation:Storage:8>", "metallum 20, machina 7, ordo 7"); //Invar
        set("<ThermalFoundation:Storage:4>", "metallum 7, ordo 14, machina 7"); //Nickel
        set("<RedstoneArsenal:Storage>", "metallum 20, machina 14, lucrum 7"); //Fluxed Electrum

        set("<appliedenergistics2:item.ItemMultiMaterial:17>", "vitreus 4, lucrum 4");
        set("<appliedenergistics2:item.ItemMultiMaterial:18>", "lucrum 2");
        set("<appliedenergistics2:item.ItemMultiMaterial:16>", "vitreus 5");
        set("<appliedenergistics2:item.ItemMultiMaterial:20>", "ignis 1, sensus 1, ordo 1");

        set("<Thaumcraft:ItemBaubleBlanks:3>", "aer 5, praecantatio 2");
        set("<Thaumcraft:ItemBaubleBlanks:4>", "terra 5, praecantatio 2");
        set("<Thaumcraft:ItemBaubleBlanks:5>", "ignis 5, praecantatio 2");
        set("<Thaumcraft:ItemBaubleBlanks:6>", "aqua 5, praecantatio 2");
        set("<Thaumcraft:ItemBaubleBlanks:7>", "ordo 5, praecantatio 2");
        set("<Thaumcraft:ItemBaubleBlanks:8>", "perditio 5, praecantatio 2");

        // Metallurgy

        set("<Metallurgy:fantasy.ore:0>", "metallum 3, herba 1, terra 1");
        set("<UndergroundBiomes:metamorphic_metal.block.fantasy.ore:*>", "metallum 3, herba 1, terra 1");
        set("<UndergroundBiomes:sedimentary_metal.block.fantasy.ore:*>", "metallum 3, herba 1, terra 1");
        set("<UndergroundBiomes:igneous_metal.block.fantasy.ore:*>", "metallum 3, herba 1, terra 1");

        set("<Metallurgy:fantasy.ore:1>", "metallum 3, terra 4");
        set("<UndergroundBiomes:metamorphic_metal.block.fantasy.ore.1:*>", "metallum 3, herba 1, terra 1");
        set("<UndergroundBiomes:sedimentary_metal.block.fantasy.ore.1:*>", "metallum 3, herba 1, terra 1");
        set("<UndergroundBiomes:igneous_metal.block.fantasy.ore.1:*>", "metallum 3, herba 1, terra 1");

        set("<Metallurgy:fantasy.ore:2>", "metallum 3, praecantatio 1, terra 1");
        set("<UndergroundBiomes:metamorphic_metal.block.fantasy.ore.2:*>", "metallum 3, herba 1, terra 1");
        set("<UndergroundBiomes:sedimentary_metal.block.fantasy.ore.2:*>", "metallum 3, herba 1, terra 1");
        set("<UndergroundBiomes:igneous_metal.block.fantasy.ore.2:*>", "metallum 3, herba 1, terra 1");

        set("<Metallurgy:fantasy.ore:4>", "metallum 3, tutamen 1, terra 1");
        set("<UndergroundBiomes:metamorphic_metal.block.fantasy.ore.4:*>", "metallum 3, herba 1, terra 1");
        set("<UndergroundBiomes:sedimentary_metal.block.fantasy.ore.4:*>", "metallum 3, herba 1, terra 1");
        set("<UndergroundBiomes:igneous_metal.block.fantasy.ore.4:*>", "metallum 3, herba 1, terra 1");

        set("<Metallurgy:fantasy.ore:5>", "metallum 3, lucrum 1, auram 1, terra 1");
        set("<UndergroundBiomes:metamorphic_metal.block.fantasy.ore.5:*>", "metallum 3, herba 1, terra 1");
        set("<UndergroundBiomes:sedimentary_metal.block.fantasy.ore.5:*>", "metallum 3, herba 1, terra 1");
        set("<UndergroundBiomes:igneous_metal.block.fantasy.ore.5:*>", "metallum 3, herba 1, terra 1");

        set("<Metallurgy:fantasy.ore:6>", "metallum 3, praecantatio 1, aer 1, terra 1");
        set("<UndergroundBiomes:metamorphic_metal.block.fantasy.ore.6:*>", "metallum 3, herba 1, terra 1");
        set("<UndergroundBiomes:sedimentary_metal.block.fantasy.ore.6:*>", "metallum 3, herba 1, terra 1");
        set("<UndergroundBiomes:igneous_metal.block.fantasy.ore.6:*>", "metallum 3, herba 1, terra 1");

        set("<Metallurgy:fantasy.ore:7>", "metallum 3, praecantatio 1, terra 1");
        set("<UndergroundBiomes:metamorphic_metal.block.fantasy.ore.7:*>", "metallum 3, herba 1, terra 1");
        set("<UndergroundBiomes:sedimentary_metal.block.fantasy.ore.7:*>", "metallum 3, herba 1, terra 1");
        set("<UndergroundBiomes:igneous_metal.block.fantasy.ore.7:*>", "metallum 3, herba 1, terra 1");

        set("<Metallurgy:fantasy.ore:8>", "metallum 3, spiritus 1, terra 1");
        set("<UndergroundBiomes:metamorphic_metal.block.fantasy.ore.8:*>", "metallum 3, herba 1, terra 1");
        set("<UndergroundBiomes:sedimentary_metal.block.fantasy.ore.8:*>", "metallum 3, herba 1, terra 1");
        set("<UndergroundBiomes:igneous_metal.block.fantasy.ore.8:*>", "metallum 3, herba 1, terra 1");

        set("<Metallurgy:fantasy.ore:11>", "metallum 3, vitreus 1, tutamen 1, terra 1");
        set("<UndergroundBiomes:metamorphic_metal.block.fantasy.ore.11:*>", "metallum 3, herba 1, terra 1");
        set("<UndergroundBiomes:sedimentary_metal.block.fantasy.ore.11:*>", "metallum 3, herba 1, terra 1");
        set("<UndergroundBiomes:igneous_metal.block.fantasy.ore.11:*>", "metallum 3, herba 1, terra 1");

        set("<Metallurgy:fantasy.ore:13>", "metallum 3, tutamen 2, terra 1");
        set("<UndergroundBiomes:metamorphic_metal.block.fantasy.ore.13:*>", "metallum 3, herba 1, terra 1");
        set("<UndergroundBiomes:sedimentary_metal.block.fantasy.ore.13:*>", "metallum 3, herba 1, terra 1");
        set("<UndergroundBiomes:igneous_metal.block.fantasy.ore.13:*>", "metallum 3, herba 1, terra 1");

        set("<Metallurgy:fantasy.ore:14>", "metallum 3, tutamen 1, auram 1, terra 1");
        set("<UndergroundBiomes:metamorphic_metal.block.fantasy.ore.14:*>", "metallum 3, herba 1, terra 1");
        set("<UndergroundBiomes:sedimentary_metal.block.fantasy.ore.14:*>", "metallum 3, herba 1, terra 1");
        set("<UndergroundBiomes:igneous_metal.block.fantasy.ore.14:*>", "metallum 3, herba 1, terra 1");


    }
}
