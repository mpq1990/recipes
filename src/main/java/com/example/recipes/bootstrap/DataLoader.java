package com.example.recipes.bootstrap;

import com.example.recipes.model.Difficulty;
import com.example.recipes.model.Ingredient;
import com.example.recipes.model.Notes;
import com.example.recipes.model.Recipe;
import com.example.recipes.repositories.CategoryRepository;
import com.example.recipes.repositories.RecipeRepository;
import com.example.recipes.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private UnitOfMeasureRepository unitOfMeasureRepository;
    private RecipeRepository recipeRepository;
    private CategoryRepository categoryRepository;

    public DataLoader(UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository recipeRepository, CategoryRepository categoryRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadData();
    }

    private void loadData() {

        /*******************************/
        /**
         * spicyGrilledChickenTacos
         */
        /*******************************/
        Recipe spicyGrilledChickenTacos = new Recipe();
        spicyGrilledChickenTacos.setDescription("Spicy grilled chicken tacos! Quick marinade, then grill. Ready in about 30 minutes. Great for a quick weeknight dinner, backyard cookouts, and tailgate parties");
        spicyGrilledChickenTacos.setCookTime(20);
        spicyGrilledChickenTacos.setPrepTime(15);
        spicyGrilledChickenTacos.setServings(6);
        spicyGrilledChickenTacos.setSource("simplyrecipes");
        spicyGrilledChickenTacos.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        spicyGrilledChickenTacos.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "Spicy Grilled Chicken Tacos\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.");
        spicyGrilledChickenTacos.setDifficulty(Difficulty.MODERATE);

        spicyGrilledChickenTacos.getCategories().add(categoryRepository.findByDescription("Mexican").get());
        spicyGrilledChickenTacos.getCategories().add(categoryRepository.findByDescription("American").get());

        Notes notesGrillChicken = new Notes();
        notesGrillChicken.setRecipeNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                "\n" +
                "\n" +
                "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!\n" +
                "\n" +
                "\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!\n" +
                "\n" +
                "Spicy Grilled Chicken TacosThe ancho chiles I use in the marinade are named for their wide shape. They are large, have a deep reddish brown color when dried, and are mild in flavor with just a hint of heat. You can find ancho chile powder at any markets that sell Mexican ingredients, or online.\n" +
                "\n" +
                "I like to put all the toppings in little bowls on a big platter at the center of the table: avocados, radishes, tomatoes, red onions, wedges of lime, and a sour cream sauce. I add arugula, as well – this green isn’t traditional for tacos, but we always seem to have some in the fridge and I think it adds a nice green crunch to the tacos.\n" +
                "\n" +
                "Everyone can grab a warm tortilla from the pile and make their own tacos just they way they like them.\n" +
                "\n" +
                "You could also easily double or even triple this recipe for a larger party. A taco and a cold beer on a warm day? Now that’s living!");

        notesGrillChicken.setRecipe(spicyGrilledChickenTacos);
        spicyGrilledChickenTacos.setNotes(notesGrillChicken);

        spicyGrilledChickenTacos.
                getIngredients().
                add(createRecipeIngredient(spicyGrilledChickenTacos, "2 tablespoons ancho chili powder", 2d, "Tablespoon"));

        spicyGrilledChickenTacos.
                getIngredients().
                add(createRecipeIngredient(spicyGrilledChickenTacos, "1 teaspoon dried oregano", 1d, "Teaspoon"));

        spicyGrilledChickenTacos.
                getIngredients().
                add(createRecipeIngredient(spicyGrilledChickenTacos, "1 teaspoon dried cumin", 1d, "Teaspoon"));

        spicyGrilledChickenTacos.
                getIngredients().
                add(createRecipeIngredient(spicyGrilledChickenTacos, "1 teaspoon sugar", 1d, "Teaspoon"));

        spicyGrilledChickenTacos.
                getIngredients().
                add(createRecipeIngredient(spicyGrilledChickenTacos, "1/2 teaspoon salt", 0.5, "Teaspoon"));

        spicyGrilledChickenTacos.
                getIngredients().
                add(createRecipeIngredient(spicyGrilledChickenTacos, "1 clove garlic, finely chopped1 clove garlic, finely chopped", 1d, "Clove"));

        spicyGrilledChickenTacos.
                getIngredients().
                add(createRecipeIngredient(spicyGrilledChickenTacos, "1 tablespoon finely grated orange zest", 1d, "Tablespoon"));

        spicyGrilledChickenTacos.
                getIngredients().
                add(createRecipeIngredient(spicyGrilledChickenTacos, "3 tablespoons fresh-squeezed orange juice", 3d, "Tablespoon"));

        spicyGrilledChickenTacos.
                getIngredients().
                add(createRecipeIngredient(spicyGrilledChickenTacos, "2 tablespoons olive oil2 tablespoons olive oil", 2d, "Tablespoon"));

        spicyGrilledChickenTacos.
                getIngredients().
                add(createRecipeIngredient(spicyGrilledChickenTacos, "4 to 6 skinless, boneless chicken thighs (1 1/4 pounds)", 1d, "Pound"));

        spicyGrilledChickenTacos.
                getIngredients().
                add(createRecipeIngredient(spicyGrilledChickenTacos, "8 small corn tortillas", 8d, "Small"));

        spicyGrilledChickenTacos.
                getIngredients().
                add(createRecipeIngredient(spicyGrilledChickenTacos, "3 cups packed baby arugula (3 ounces)", 3d, "Cup"));

        spicyGrilledChickenTacos.
                getIngredients().
                add(createRecipeIngredient(spicyGrilledChickenTacos, "2 medium ripe avocados, sliced", 2d, "Sliced"));

        spicyGrilledChickenTacos.
                getIngredients().
                add(createRecipeIngredient(spicyGrilledChickenTacos, "4 radishes, thinly sliced", 4d, "Sliced"));

        spicyGrilledChickenTacos.
                getIngredients().
                add(createRecipeIngredient(spicyGrilledChickenTacos, "1/2 pint cherry tomatoes, halved", 0.5d, "Pint"));

        spicyGrilledChickenTacos.
                getIngredients().
                add(createRecipeIngredient(spicyGrilledChickenTacos, "1/4 red onion, thinly sliced", 0.25d, "Sliced"));

        spicyGrilledChickenTacos.
                getIngredients().
                add(createRecipeIngredient(spicyGrilledChickenTacos, "Roughly chopped cilantro", 1d, "Chopped"));

        spicyGrilledChickenTacos.
                getIngredients().
                add(createRecipeIngredient(spicyGrilledChickenTacos, "1/2 cup sour cream thinned with 1/4 cup milk", 0.5d, "Cup"));

        spicyGrilledChickenTacos.
                getIngredients().
                add(createRecipeIngredient(spicyGrilledChickenTacos, "1 lime, cut into wedges", 1d, "Wedge"));

        recipeRepository.save(spicyGrilledChickenTacos);


        /*******************************/
        /**
         * guacamole
         */
        /*******************************/
        Recipe guacamole = new Recipe();
        guacamole.setDescription("The best guacamole keeps it simple: just ripe avocados, salt, a squeeze of lime, onions, chiles, cilantro, and some chopped tomato. Serve it as a dip at your next party or spoon it on top of tacos for an easy dinner upgrade.");
        guacamole.setCookTime(10);
        guacamole.setPrepTime(10);
        guacamole.setServings(4);
        guacamole.setSource("simplyrecipes");
        guacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacamole.setDirections("1 Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "\n" +
                "\n" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n" +
                "\n" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "4 Serve: Serve immediately, or if making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.");
        guacamole.setDifficulty(Difficulty.EASY);

        guacamole.getCategories().add(categoryRepository.findByDescription("Mexican").get());
        guacamole.getCategories().add(categoryRepository.findByDescription("American").get());

        Notes notesGuacamole = new Notes();
        notesGuacamole.setRecipeNotes("Guacamole! Did you know that over 2 billion pounds of avocados are consumed each year in the U.S.? (Google it.) That’s over 7 pounds per person. I’m guessing that most of those avocados go into what has become America’s favorite dip, guacamole.\n" +
                "\n" +
                "WHERE DOES GUACAMOLE COME FROM?\n" +
                "The word “guacamole”, and the dip, are both originally from Mexico, where avocados have been cultivated for thousands of years. The name is derived from two Aztec Nahuatl words—ahuacatl (avocado) and molli (sauce).\n" +
                "\n" +
                "\n" +
                "WATCH OUR VIDEO ON HOW TO MAKE GUACAMOLE!\n" +
                "\n" +
                "Play\n" +
                "Unmute\n" +
                "Current Time \n" +
                "0:02\n" +
                "/\n" +
                "Duration \n" +
                "1:05\n" +
                " \n" +
                "Fullscreen\n" +
                "INGREDIENTS FOR EASY GUACAMOLE\n" +
                "All you really need to make guacamole is ripe avocados and salt. After that, a little lime or lemon juice—a splash of acidity—will help to balance the richness of the avocado. Then if you want, add chopped cilantro, chiles, onion, and/or tomato.\n" +
                "\n" +
                "GUACAMOLE TIP: USE RIPE AVOCADOS\n" +
                "The trick to making perfect guacamole is using ripe avocados that are just the right amount of ripeness. Not ripe enough and the avocado will be hard and tasteless. Too ripe and the taste will be off.\n" +
                "\n" +
                "Check for ripeness by gently pressing the outside of the avocado. If there is no give, the avocado is not ripe yet and will not taste good. If there is a little give, the avocado is ripe. If there is a lot of give, the avocado may be past ripe and not good. In this case, taste test first before using.\n" +
                "\n" +
                "Remove the pit from the avocado with a chef knife\n" +
                "THE BEST WAY TO CUT AN AVOCADO\n" +
                "To slice open an avocado, cut it in half lengthwise with a sharp chef’s knife and twist apart the sides. One side will have the pit. To remove it, you can do one of two things:\n" +
                "\n" +
                "Method #1: Gently tap the pit with your chef’s knife so the knife gets wedged into the pit. Twist your knife slightly to dislodge the pit and lift to remove. If you use this method, first protect your hand with a thick kitchen towel before proceeding.\n" +
                "Method #2: Cut the side with the pit in half again, exposing more of the pit. Use your fingers or a spoon to remove the pit\n" +
                "Once the pit is removed, just cut the avocado into chunks right inside the peel and use a spoon to scoop them out.\n" +
                "\n" +
                "Still curious? Read more about How to Cut and Peel an Avocado\n" +
                "Homemade guacamole on a chip\n" +
                "GUACAMOLE VARIATIONS\n" +
                "Once you have basic guacamole down, feel free to experiment with variations including strawberries, peaches, pineapple, mangoes, even watermelon. One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). You can get creative with homemade guacamole!\n" +
                "\n" +
                "Simple Guacamole: The simplest version of guacamole is just mashed avocados with salt. Don’t let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "Quick guacamole: For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Don’t have enough avocados? To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "Here are a few other guacamole recipes to try:\n" +
                "\n" +
                "Spicy Three-Chile Guacamole\n" +
                "Strawberry Guacamole\n" +
                "Guacamole with Charred Sweet Corn, Bacon, and Tomato\n" +
                "Copycat Chipotle Guacamole\n" +
                "Bacon and Blue Cheese Guacamole\n" +
                "Authentic guacamole in a bowl with chips\n" +
                "OTHER WAYS TO USE GUACAMOLE\n" +
                "Guacamole has a role in the kitchen beyond a party dip, of course. It’s great scooped on top of nachos and also makes an excellent topping or side for enchiladas, tacos, grilled salmon, or oven-baked chicken.\n" +
                "\n" +
                "Guacamole is great in foods, as well. Try mixing some guacamole into a tuna sandwich or your next batch of deviled eggs.\n" +
                "\n" +
                "HOW TO STORE GUACAMOLE\n" +
                "Guacamole is best eaten right after it’s made. Like apples, avocados start to oxidize and turn brown once they’ve been cut. That said, the acid in the lime juice you add to guacamole can help slow down that process, and if you store the guacamole properly, you can easily make it a few hours ahead if you are preparing for a party.\n" +
                "\n" +
                "The trick to keeping guacamole green is to make sure air doesn’t touch it! Transfer it to a container, cover with plastic wrap, and press down on the plastic wrap to squeeze out any air pockets. Make sure any exposed surface of the guacamole is touching the plastic wrap, not air. This will keep the amount of browning to a minimum.\n" +
                "\n" +
                "You can store the guacamole in the fridge this way for up to three days.\n" +
                "\n" +
                "If you leave the guacamole exposed to air, it will start to brown and discolor. That browning isn’t very appetizing, but the guacamole is still good. You can either scrape off the brown parts and discard, or stir them into the rest of the guacamole.");

        notesGuacamole.setRecipe(guacamole);
        guacamole.setNotes(notesGuacamole);


        guacamole.
                getIngredients().
                add(createRecipeIngredient(guacamole, "2 ripe avocados", 2d, null));

        guacamole.
                getIngredients().
                add(createRecipeIngredient(guacamole, "1/4 teaspoon of salt, more to taste", 0.25d, "Teaspoon"));

        guacamole.
                getIngredients().
                add(createRecipeIngredient(guacamole, "1 tablespoon fresh lime juice or lemon juice", 1d, "Tablespoon"));

        guacamole.
                getIngredients().
                add(createRecipeIngredient(guacamole, "2 tablespoons to 1/4 cup of minced red onion or thinly sliced green onion", 2d, "Tablespoon"));

        guacamole.
                getIngredients().
                add(createRecipeIngredient(guacamole, "1-2 serrano chiles, stems and seeds removed, minced", 1d, "Minced"));

        guacamole.
                getIngredients().
                add(createRecipeIngredient(guacamole, "2 tablespoons cilantro (leaves and tender stems), finely chopped", 2d, "Tablespoon"));

        guacamole.
                getIngredients().
                add(createRecipeIngredient(guacamole, "A dash of freshly grated black pepper", 1d, "Dash"));

        guacamole.
                getIngredients().
                add(createRecipeIngredient(guacamole, "1/2 ripe tomato, seeds and pulp removed, chopped", 0.5d, "Chopped"));

        guacamole.
                getIngredients().
                add(createRecipeIngredient(guacamole, "Red radishes or jicama, to garnish", 1d, null));

        guacamole.
                getIngredients().
                add(createRecipeIngredient(guacamole, "Tortilla chips, to serve", 1d, null));

        recipeRepository.save(guacamole);

    }

    private Ingredient createRecipeIngredient(Recipe recipe, String description, Double amount, String unitOfMeasurement) {
        Ingredient ingredient = new Ingredient();
        ingredient.setDescription(description);
        ingredient.setAmount(BigDecimal.valueOf(amount));
        ingredient.setRecipe(recipe);
        if (unitOfMeasurement != null) {
            ingredient.setUnitOfMeasure(unitOfMeasureRepository.findByUom(unitOfMeasurement).get());
        }
        return ingredient;
    }
}
