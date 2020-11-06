package com.decouikit.atom.menu.repository

import android.content.Context
import com.decouikit.atom.R
import com.decouikit.atom.menu.model.NavigationAdapterItemType
import com.decouikit.atom.menu.model.NavigationItem
import com.decouikit.atom.menu.model.NavigationItemType
import io.reactivex.Observable

object MenuRepository {

    fun getData(context: Context): Observable<List<NavigationItem>> {
        val result = mutableListOf<NavigationItem>()
        result.addAll(getHeaderItem(context))
        result.addAll(getLists(context))
        result.addAll(getCards(context))
        result.addAll(getParallax(context))
        result.addAll(getRtlColorChange(context))
        result.addAll(getLogin(context))
        result.addAll(getRegister(context))
        result.addAll(getForgotPassword(context))
        result.addAll(getOldNewPassword(context))
        result.addAll(getImageGallery(context))
        result.addAll(getSplashScreen(context))
        result.addAll(getCheckBox(context))
        result.addAll(getSearch(context))
        result.addAll(getSmallComponents(context))
        result.addAll(getWizards(context))
        result.addAll(getTabs(context))
        result.addAll(getTimeline(context))
        result.addAll(getRadio(context))
        result.addAll(getRange(context))
        result.addAll(getToggle(context))
        result.addAll(getSelect(context))
        return Observable.just(result)
    }

    private fun getHeaderItem(context: Context): List<NavigationItem> {
        val result = mutableListOf<NavigationItem>()
        result.add(
            NavigationItem(
                id = NavigationItemType.HEADER,
                title = context.getString(R.string.nav_header_title),
                subtitle = context.getString(R.string.nav_header_subtitle),
                itemType = NavigationAdapterItemType.HEADER
            )
        )
        return result
    }

    private fun getCheckBox(context: Context): List<NavigationItem> {
        val result = mutableListOf<NavigationItem>()
        val submenuCheckbox = mutableListOf<NavigationItem>()
        submenuCheckbox.add(
            NavigationItem(
                id = NavigationItemType.CHECKBOX_SIMPLE_LEFT,
                title = context.getString(R.string.checkbox_simple_left)

            )
        )
        submenuCheckbox.add(
            NavigationItem(
                id = NavigationItemType.CHECKBOX_SIMPLE_RIGHT,
                title = context.getString(R.string.checkbox_simple_right)
            )
        )
        submenuCheckbox.add(
            NavigationItem(
                id = NavigationItemType.CHECKBOX_AVATAR_LEFT,
                title = context.getString(R.string.checkbox_avatar_left)
            )
        )
        submenuCheckbox.add(
            NavigationItem(
                id = NavigationItemType.CHECKBOX_AVATAR_RIGHT,
                title = context.getString(R.string.checkbox_avatar_right)
            )
        )
        submenuCheckbox.add(
            NavigationItem(
                id = NavigationItemType.CHECKBOX_ICON_LEFT,
                title = context.getString(R.string.checkbox_icon_left)
            )
        )
        submenuCheckbox.add(
            NavigationItem(
                id = NavigationItemType.CHECKBOX_ICON_RIGHT,
                title = context.getString(R.string.checkbox_icon_right)
            )
        )
        result.add(
            NavigationItem(
                id = NavigationItemType.MENU_CHECKBOX,
                title = context.getString(R.string.left_menu_checkbox),
                navigationList = submenuCheckbox
            )
        )
        return result
    }

    private fun getRadio(context: Context): List<NavigationItem> {
        val result = mutableListOf<NavigationItem>()
        val submenuRadio = mutableListOf<NavigationItem>()
        submenuRadio.add(
            NavigationItem(
                id = NavigationItemType.RADIO_BUTTON_SIMPLE_LEFT,
                title = context.getString(R.string.radiobutton_simple_left)

            )
        )
        submenuRadio.add(
            NavigationItem(
                id = NavigationItemType.RADIO_BUTTON_SIMPLE_RIGHT,
                title = context.getString(R.string.radiobutton_simple_right)
            )
        )
        submenuRadio.add(
            NavigationItem(
                id = NavigationItemType.RADIO_BUTTON_AVATAR_LEFT,
                title = context.getString(R.string.radiobutton_avatar_left)
            )
        )
        submenuRadio.add(
            NavigationItem(
                id = NavigationItemType.RADIO_BUTTON_AVATAR_RIGHT,
                title = context.getString(R.string.radiobutton_avatar_right)
            )
        )
        submenuRadio.add(
            NavigationItem(
                id = NavigationItemType.RADIO_BUTTON_ICON_LEFT,
                title = context.getString(R.string.radiobutton_icon_left)
            )
        )
        submenuRadio.add(
            NavigationItem(
                id = NavigationItemType.RADIO_BUTTON_ICON_RIGHT,
                title = context.getString(R.string.radiobutton_icon_right)
            )
        )
        result.add(
            NavigationItem(
                id = NavigationItemType.MENU_RADIO,
                title = context.getString(R.string.left_menu_radio),
                navigationList = submenuRadio
            )
        )
        return result
    }

    private fun getToggle(context: Context): List<NavigationItem> {
        val result = mutableListOf<NavigationItem>()
        val submenuToggle = mutableListOf<NavigationItem>()
        submenuToggle.add(
            NavigationItem(
                id = NavigationItemType.TOGGLE_SIMPLE,
                title = context.getString(R.string.toggle_simple)

            )
        )
        submenuToggle.add(
            NavigationItem(
                id = NavigationItemType.TOGGLE_DESC,
                title = context.getString(R.string.toggle_desc)

            )
        )
        submenuToggle.add(
            NavigationItem(
                id = NavigationItemType.TOGGLE_GROUP,
                title = context.getString(R.string.toggle_group)

            )
        )
        result.add(
            NavigationItem(
                id = NavigationItemType.MENU_TOGGLE,
                title = context.getString(R.string.left_menu_toggle),
                navigationList = submenuToggle
            )
        )
        return result
    }

    private fun getSmallComponents(context: Context): List<NavigationItem> {
        val result = mutableListOf<NavigationItem>()
        val submenuSmallComponents = mutableListOf<NavigationItem>()
        submenuSmallComponents.add(
            NavigationItem(
                id = NavigationItemType.SMALL_COMPONENTS_ALL,
                title = context.getString(R.string.all)
            )
        )
        result.add(
            NavigationItem(
                id = NavigationItemType.MENU_SMALL_COMPONENTS,
                title = context.getString(R.string.left_menu_small_components),
                navigationList = submenuSmallComponents
            )
        )
        return result
    }

    private fun getSearch(context: Context): List<NavigationItem> {
        val result = mutableListOf<NavigationItem>()
        val submenuSearch = mutableListOf<NavigationItem>()
        submenuSearch.add(
            NavigationItem(
                id = NavigationItemType.SEARCH_SIMPLE,
                title = context.getString(R.string.search_simple)
            )
        )
        submenuSearch.add(
            NavigationItem(
                id = NavigationItemType.SEARCH_TOP_BAR,
                title = context.getString(R.string.search_top_bar)
            )
        )
        result.add(
            NavigationItem(
                id = NavigationItemType.MENU_SEARCH,
                title = context.getString(R.string.left_menu_search),
                navigationList = submenuSearch
            )
        )
        return result
    }

    private fun getLogin(context: Context): List<NavigationItem> {
        val result = mutableListOf<NavigationItem>()
        val submenuLogin = mutableListOf<NavigationItem>()
        submenuLogin.add(
            NavigationItem(
                id = NavigationItemType.LOGIN_LOGO_1,
                title = context.getString(R.string.login_logo_1)
            )
        )
        result.add(
            NavigationItem(
                id = NavigationItemType.MENU_LOGIN,
                title = context.getString(R.string.left_menu_login),
                navigationList = submenuLogin
            )
        )
        return result
    }

    private fun getRegister(context: Context): List<NavigationItem> {
        val result = mutableListOf<NavigationItem>()
        val list = mutableListOf<NavigationItem>()
        list.add(
            NavigationItem(
                id = NavigationItemType.REGISTER_LOGO_1,
                title = context.getString(R.string.register_logo_1)
            )
        )
        result.add(
            NavigationItem(
                id = NavigationItemType.MENU_REGISTER,
                title = context.getString(R.string.left_menu_register),
                navigationList = list
            )
        )
        return result
    }

    private fun getForgotPassword(context: Context): List<NavigationItem> {
        val result = mutableListOf<NavigationItem>()
        val list = mutableListOf<NavigationItem>()
        list.add(
            NavigationItem(
                id = NavigationItemType.FORGOT_PASSWORD_SIMPLE,
                title = context.getString(R.string.forgot_pass_simple)
            )
        )
        result.add(
            NavigationItem(
                id = NavigationItemType.MENU_FORGOT_PASSWORD,
                title = context.getString(R.string.left_menu_forgot_pass),
                navigationList = list
            )
        )
        return result
    }

    private fun getOldNewPassword(context: Context): List<NavigationItem> {
        val result = mutableListOf<NavigationItem>()
        val list = mutableListOf<NavigationItem>()
        list.add(
            NavigationItem(
                id = NavigationItemType.OLD_NEW_PASS_WITH_BG,
                title = context.getString(R.string.new_pass_with_bg)
            )
        )
        result.add(
            NavigationItem(
                id = NavigationItemType.MENU_OLD_NEW_PASSWORD,
                title = context.getString(R.string.left_menu_old_new_pass),
                navigationList = list
            )
        )
        return result
    }

    private fun getLists(context: Context): List<NavigationItem> {
        val result = mutableListOf<NavigationItem>()
        val submenuLists = mutableListOf<NavigationItem>()

        submenuLists.add(
            NavigationItem(
                id = NavigationItemType.LIST_EXPANDABLE,
                title = context.getString(R.string.expandable),
                navigationList = getExpandable(context)
            )
        )

        submenuLists.add(
            NavigationItem(
                id = NavigationItemType.LIST_DRAG_DROP,
                title = context.getString(R.string.drag_drop),
                navigationList = getDragAndDrop(context)
            )
        )
        submenuLists.add(
            NavigationItem(
                id = NavigationItemType.LIST_SWIPE_TO_DISMISS,
                title = context.getString(R.string.swipe_to_dismiss),
                navigationList = getSwipeToDismiss(context)
            )
        )
        result.add(
            NavigationItem(
                id = NavigationItemType.MENU_LIST,
                title = context.getString(R.string.left_menu_lists),
                navigationList = submenuLists
            )
        )
        return result
    }


    private fun getExpandable(context: Context): List<NavigationItem> {
        val list = mutableListOf<NavigationItem>()
        list.add(
            NavigationItem(
                id = NavigationItemType.LIST_EXPANDABLE_1,
                title = context.getString(R.string.expandable_list_big_image)
            )
        )
        return list
    }

    private fun getDragAndDrop(context: Context): List<NavigationItem> {
        val list = mutableListOf<NavigationItem>()
        list.add(
            NavigationItem(
                id = NavigationItemType.LIST_DRAG_DROP_1,
                title = context.getString(R.string.drag_drop_small_item_header)
            )
        )
        return list
    }

    private fun getSwipeToDismiss(context: Context): List<NavigationItem> {
        val list = mutableListOf<NavigationItem>()
        list.add(
            NavigationItem(
                id = NavigationItemType.LIST_SWIPE_TO_DISMISS_1,
                title = context.getString(R.string.swipe_button)
            )
        )
        list.add(
            NavigationItem(
                id = NavigationItemType.LIST_SWIPE_TO_DISMISS_2,
                title = context.getString(R.string.swipe_icons)
            )
        )
        return list
    }

    private fun getCards(context: Context): List<NavigationItem> {
        val result = mutableListOf<NavigationItem>()
        val list = mutableListOf<NavigationItem>()
        list.add(
            NavigationItem(
                id = NavigationItemType.LIST_GOOGLE_CARDS_1,
                title = context.getString(R.string.styled_cards)
            )
        )
        list.add(
            NavigationItem(
                id = NavigationItemType.LIST_GOOGLE_CARDS_2,
                title = context.getString(R.string.styled_cards_3)
            )
        )
        list.add(
            NavigationItem(
                id = NavigationItemType.LIST_GOOGLE_CARDS_3,
                title = context.getString(R.string.full_image_cards)
            )
        )
        list.add(
            NavigationItem(
                id = NavigationItemType.LIST_GOOGLE_CARDS_9,
                title = context.getString(R.string.social_thumb_card)
            )
        )
        list.add(
            NavigationItem(
                id = NavigationItemType.LIST_GOOGLE_CARDS_8,
                title = context.getString(R.string.cards_social)
            )
        )
        list.add(
            NavigationItem(
                id = NavigationItemType.LIST_GOOGLE_CARDS_6,
                title = context.getString(R.string.cards_category)
            )
        )
        list.add(
            NavigationItem(
                id = NavigationItemType.LIST_GOOGLE_CARDS_7,
                title = context.getString(R.string.cards_image)
            )
        )
        list.add(
            NavigationItem(
                id = NavigationItemType.LIST_GOOGLE_CARDS_5,
                title = context.getString(R.string.shopping_cards)
            )
        )
        list.add(
            NavigationItem(
                id = NavigationItemType.LIST_GOOGLE_CARDS_10,
                title = context.getString(R.string.e_commerce_thumb)
            )
        )
        list.add(
            NavigationItem(
                id = NavigationItemType.LIST_GOOGLE_CARDS_4,
                title = context.getString(R.string.full_cards_avatar)
            )
        )
        result.add(
            NavigationItem(
                id = NavigationItemType.MENU_CARDS,
                title = context.getString(R.string.left_menu_cards),
                navigationList = list
            )
        )
        return result
    }

    private fun getImageGallery(context: Context): List<NavigationItem> {
        val result = mutableListOf<NavigationItem>()
        val submenuImageGallery = mutableListOf<NavigationItem>()
        submenuImageGallery.add(
            NavigationItem(
                id = NavigationItemType.IMAGE_GALLERY_CATEGORIES,
                title = context.getString(R.string.image_gallery_categories)
            )
        )
        result.add(
            NavigationItem(
                id = NavigationItemType.MENU_IMAGE_GALLERY,
                title = context.getString(R.string.left_menu_image_gallery),
                navigationList = submenuImageGallery
            )
        )
        return result
    }


    private fun getSplashScreen(context: Context): List<NavigationItem> {
        val result = mutableListOf<NavigationItem>()
        val list = mutableListOf<NavigationItem>()
        list.add(
            NavigationItem(
                id = NavigationItemType.SPLASH_SCREEN_SIMPLE,
                title = context.getString(R.string.splash_screen_simple)
            )
        )
        result.add(
            NavigationItem(
                id = NavigationItemType.MENU_SPLASH_SCREEN,
                title = context.getString(R.string.left_menu_splash),
                navigationList = list
            )
        )
        return result
    }

    private fun getTimeline(context: Context): List<NavigationItem> {
        val result = mutableListOf<NavigationItem>()
        val submenuTimeline = mutableListOf<NavigationItem>()
        submenuTimeline.add(
            NavigationItem(
                id = NavigationItemType.TIMELINE_LEFT,
                title = context.getString(R.string.timeline_left)
            )
        )
        submenuTimeline.add(
            NavigationItem(
                id = NavigationItemType.TIMELINE_CENTER,
                title = context.getString(R.string.timeline_center)
            )
        )
        submenuTimeline.add(
            NavigationItem(
                id = NavigationItemType.TIMELINE_RIGHT,
                title = context.getString(R.string.timeline_right)
            )
        )
        result.add(
            NavigationItem(
                id = NavigationItemType.MENU_TIMELINE,
                title = context.getString(R.string.left_menu_timeline),
                navigationList = submenuTimeline
            )
        )
        return result
    }

    private fun getWizards(context: Context): List<NavigationItem> {
        val result = mutableListOf<NavigationItem>()
        val submenuWizards = mutableListOf<NavigationItem>()
        submenuWizards.add(
            NavigationItem(
                id = NavigationItemType.WIZARD_WALK_THROUGH,
                title = context.getString(R.string.wizard_walk_through)
            )
        )
        submenuWizards.add(
            NavigationItem(
                id = NavigationItemType.WIZARD_E_COMMERCE,
                title = context.getString(R.string.wizard_e_commerce)
            )
        )
        submenuWizards.add(
            NavigationItem(
                id = NavigationItemType.WIZARD_PROFILES,
                title = context.getString(R.string.wizard_profiles)
            )
        )
        submenuWizards.add(
            NavigationItem(
                id = NavigationItemType.WIZARD_SOCIAL,
                title = context.getString(R.string.wizard_social)
            )
        )
        result.add(
            NavigationItem(
                id = NavigationItemType.MENU_WIZARD,
                title = context.getString(R.string.left_menu_wizard),
                navigationList = submenuWizards
            )
        )
        return result
    }

    private fun getTabs(context: Context): List<NavigationItem> {
        val result = mutableListOf<NavigationItem>()
        val submenuTabs = mutableListOf<NavigationItem>()
        submenuTabs.add(
            NavigationItem(
                id = NavigationItemType.TAB_BOTTOM_TEXT,
                title = context.getString(R.string.tab_bottom_text)
            )
        )
        submenuTabs.add(
            NavigationItem(
                id = NavigationItemType.TAB_BOTTOM_ICONS,
                title = context.getString(R.string.tab_bottom_icons)
            )
        )
        submenuTabs.add(
            NavigationItem(
                id = NavigationItemType.TAB_TOP_TEXT,
                title = context.getString(R.string.tab_top_text)
            )
        )
        submenuTabs.add(
            NavigationItem(
                id = NavigationItemType.TAB_TOP_ICONS,
                title = context.getString(R.string.tab_top_icons)
            )
        )
        result.add(
            NavigationItem(
                id = NavigationItemType.MENU_TAB,
                title = context.getString(R.string.left_menu_tab),
                navigationList = submenuTabs
            )
        )
        return result
    }

    private fun getRange(context: Context): List<NavigationItem> {
        val result = mutableListOf<NavigationItem>()
        val submenuRange = mutableListOf<NavigationItem>()
        submenuRange.add(
            NavigationItem(
                id = NavigationItemType.RANGE_ALL,
                title = context.getString(R.string.all)
            )
        )
        result.add(
            NavigationItem(
                id = NavigationItemType.MENU_RANGE,
                title = context.getString(R.string.left_menu_range),
                navigationList = submenuRange
            )
        )
        return result
    }

    private fun getParallax(context: Context): List<NavigationItem> {
        val result = mutableListOf<NavigationItem>()
        val submenuParallax = mutableListOf<NavigationItem>()
        submenuParallax.add(
            NavigationItem(
                id = NavigationItemType.PARALLAX_FRIENDS,
                title = context.getString(R.string.parallax_friends)
            )
        )
        submenuParallax.add(
            NavigationItem(
                id = NavigationItemType.PARALLAX_SHOPPING,
                title = context.getString(R.string.parallax_shopping)
            )
        )
        submenuParallax.add(
            NavigationItem(
                id = NavigationItemType.PARALLAX_PROFILE,
                title = context.getString(R.string.parallax_profile)
            )
        )
        result.add(
            NavigationItem(
                id = NavigationItemType.MENU_PARALLAX,
                title = context.getString(R.string.left_menu_parallax),
                navigationList = submenuParallax
            )
        )
        return result
    }

    private fun getRtlColorChange(context: Context): List<NavigationItem> {
        val result = mutableListOf<NavigationItem>()
        val submenuColor = mutableListOf<NavigationItem>()
        submenuColor.add(
            NavigationItem(
                id = NavigationItemType.RTL_COLOR_CHANGE_TEST,
                title = context.getString(R.string.rtl_test)
            )
        )
        result.add(
            NavigationItem(
                id = NavigationItemType.MENU_RTL_COLOR_CHANGE,
                title = context.getString(R.string.left_menu_color),
                navigationList = submenuColor
            )
        )
        return result
    }

    private fun getSelect(context: Context): List<NavigationItem> {
        val result = mutableListOf<NavigationItem>()
        val list = mutableListOf<NavigationItem>()
        list.add(
            NavigationItem(
                id = NavigationItemType.SINGLE_SELECT,
                title = context.getString(R.string.single_select)
            )
        )
        list.add(
            NavigationItem(
                id = NavigationItemType.MULTI_SELECT,
                title = context.getString(R.string.multi_select)
            )
        )
        result.add(
            NavigationItem(
                id = NavigationItemType.MENU_SELECT,
                title = context.getString(R.string.left_menu_select),
                navigationList = list
            )
        )
        return result
    }
}