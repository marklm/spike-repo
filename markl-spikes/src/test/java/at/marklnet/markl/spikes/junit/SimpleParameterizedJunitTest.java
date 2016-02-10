package at.marklnet.markl.spikes.junit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class SimpleParameterizedJunitTest {
    
    private MenueHelper menuHelper;

    
    
    
    @Parameters(name = "namelist")
    public static Collection data() {
        
        Object[][] values = new Object[][] { {new MenueHelper("menu1", "view1")},
                                    {new MenueHelper("menu2", "view2")},
                                    {new MenueHelper("menu3", "view3")},
                                    {new MenueHelper("menu3.1", "view3.1", new IAdditionalExecutor() {
                                        
//                                        @Override
                                        public void performAdditional() {
                                            System.out.println("Hier teste ich noch etwas zusätzliches :-) !!!!!!!!!!!!!!!!!!!!!!!");
                                            
                                        }
                                    })},
                                    {new MenueHelper("menu4", "view4")},
                                    {new MenueHelper("menu5", "view5")} };

        return Arrays.asList(values);
                                    
        
//        final List<MenueHelper> rValue = new ArrayList<SimpleParameterizedJunitTest.MenueHelper>();
//        
//        rValue.add(new MenueHelper("menu1", "view1"));
//        rValue.add(new MenueHelper("menu2", "view2"));
//        rValue.add(new MenueHelper("menu3", "view3"));
//        
//        rValue.add(new MenueHelper("menu3.1", "view3.1", new IAdditionalExecutor() {
//            
//            @Override
//            public void performAdditional() {
//                System.out.println("Hier teste ich noch etwas zusätzliches :-) !!!!!!!!!!!!!!!!!!!!!!!");
//                
//            }
//        }));
//        
//        rValue.add(new MenueHelper("menu4", "view4"));
//        rValue.add(new MenueHelper("menu5", "view5"));
//        rValue.add(new MenueHelper("menu6", "view6"));
//        
//        return rValue;
    }
 
 
    public SimpleParameterizedJunitTest(MenueHelper helper) {
        this.menuHelper = helper;
    }
 
    @Test
    public void test() {

        System.out.println("Hier würde ich einen Menüpunkt klicken: " + menuHelper.getMenuLink());
        
        System.out.println("Hier würde ich die View checken: " + menuHelper.getExpectedViewTitle());
        final String currentView = menuHelper.getExpectedViewTitle(); // ==> wird ausgelesen
        assertEquals(menuHelper.getExpectedViewTitle(), currentView);
        
        if (menuHelper.hasOptionalAsserts()) {
            System.out.println("Hier würde ich die zusätzlichen Checks, nur für diesen Test ausführen. ");
            menuHelper.getOptionalAsserts().performAdditional();
        }
    }

    static class MenueHelper {
        
        private String menuLink;
        
        private String expectedViewTitle;
        
        private IAdditionalExecutor optionalAsserts;

        /**
         * @param menuLink
         * @param expectedViewTitle
         * @param optionalAsserts
         */
        public MenueHelper(String menuLink, String expectedViewTitle) {
            this.menuLink = menuLink;
            this.expectedViewTitle = expectedViewTitle;
        } 
        
        /**
         * @param menuLink
         * @param expectedViewTitle
         * @param optionalAsserts
         */
        public MenueHelper(String menuLink, String expectedViewTitle, IAdditionalExecutor optionalAsserts) {
            this.menuLink = menuLink;
            this.expectedViewTitle = expectedViewTitle;
            this.optionalAsserts = optionalAsserts;
        }

        /**
         * @return the menuLink
         */
        public String getMenuLink() {
            return menuLink;
        }

        /**
         * @return the expectedViewTitle
         */
        public String getExpectedViewTitle() {
            return expectedViewTitle;
        }

        /**
         * @return the optionalAsserts
         */
        public IAdditionalExecutor getOptionalAsserts() {
            return optionalAsserts;
        }
        
        public boolean hasOptionalAsserts() {
            return getOptionalAsserts() != null;
        }
        
        
        
        
    }
    
    interface IAdditionalExecutor {
        
        void performAdditional();
        
    }
    
    
    
}
