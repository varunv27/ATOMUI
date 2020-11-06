package com.decouikit.atom.menu.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.decouikit.atom.R
import com.decouikit.atom.components.checkbox.avatar_left.activity.CheckboxAvatarLeftActivity
import com.decouikit.atom.components.checkbox.avatar_right.activity.CheckboxAvatarRightActivity
import com.decouikit.atom.components.checkbox.icon_left.activity.CheckboxIconLeftActivity
import com.decouikit.atom.components.checkbox.icon_right.activity.CheckboxIconRightActivity
import com.decouikit.atom.components.checkbox.simple_left.activity.CheckboxSimpleLeftActivity
import com.decouikit.atom.components.checkbox.simple_right.activity.CheckboxSimpleRightActivity
import com.decouikit.atom.components.forgot_pass.activity.ForgotPassActivity
import com.decouikit.atom.components.image_gallery.activity.ImageGalleryCategoryActivity
import com.decouikit.atom.components.cards.ecommerce_category.activity.CardCategoryActivity
import com.decouikit.atom.components.cards.ecommerce_image_card.activity.CardImageActivity
import com.decouikit.atom.components.cards.ecommerce_thumb.activity.ThumbActivity
import com.decouikit.atom.components.cards.full_image.activity.CardFullImageActivity
import com.decouikit.atom.components.cards.full_image_with_avatar.activity.CardFullImageAvatarActivity
import com.decouikit.atom.components.cards.shoping_cart.activity.ShoppingCartActivity
import com.decouikit.atom.components.cards.social_color_card.activity.CardColorActivity
import com.decouikit.atom.components.cards.social_thumb.activity.SocialThumbActivity
import com.decouikit.atom.components.cards.styled.activity.StyledCardActivity
import com.decouikit.atom.components.cards.styled_2.activity.StyledTwoCardActivity
import com.decouikit.atom.components.login.activity.LoginActivity
import com.decouikit.atom.components.navigation.activity.NavBottomIconActivity
import com.decouikit.atom.components.navigation.activity.NavBottomTextActivity
import com.decouikit.atom.components.navigation.activity.NavTopIconActivity
import com.decouikit.atom.components.navigation.activity.NavTopTextActivity
import com.decouikit.atom.components.old_new_pass.activity.NewPassActivity
import com.decouikit.atom.components.parallax.product.activity.FriendsActivity
import com.decouikit.atom.components.parallax.profile.activity.ProfileActivity
import com.decouikit.atom.components.parallax.shopping.activity.ShoppingActivity
import com.decouikit.atom.components.radio_button.avatar_left.activity.RadioButtonAvatarLeftActivity
import com.decouikit.atom.components.radio_button.avatar_right.activity.RadioButtonAvatarRightActivity
import com.decouikit.atom.components.radio_button.icon_left.activity.RadioButtonIconLeftActivity
import com.decouikit.atom.components.radio_button.icon_right.activity.RadioButtonIconRightActivity
import com.decouikit.atom.components.radio_button.simple_left.activity.RadioButtonSimpleLeftActivity
import com.decouikit.atom.components.radio_button.simple_right.activity.RadioButtonSimpleRightActivity
import com.decouikit.atom.components.range.activity.RangeActivity
import com.decouikit.atom.components.register.activity.RegisterActivity
import com.decouikit.atom.components.rtl_color_change.activity.RtlColorChangeActivity
import com.decouikit.atom.components.search.simple.activity.SearchSimpleActivity
import com.decouikit.atom.components.search.top_bar.activity.SearchTopBarActivity
import com.decouikit.atom.components.select.multi.activity.MultiSelectActivity
import com.decouikit.atom.components.select.single.activity.SingleSelectActivity
import com.decouikit.atom.components.small_components.activity.SmallComponentsActivity
import com.decouikit.atom.components.splash.activity.SplashSimpleActivity
import com.decouikit.atom.components.timeline.center.activity.TimelineCenterActivity
import com.decouikit.atom.components.timeline.left.activity.TimelineLeftActivity
import com.decouikit.atom.components.timeline.right.activity.TimelineRightActivity
import com.decouikit.atom.components.toggle.description.activity.ToggleDescActivity
import com.decouikit.atom.components.toggle.group.activity.ToggleGroupActivity
import com.decouikit.atom.components.toggle.simple.activity.ToggleSimpleActivity
import com.decouikit.atom.components.wizard.e_commerce.activity.WizardECommerceActivity
import com.decouikit.atom.components.wizard.profile.activity.WizardProfileActivity
import com.decouikit.atom.components.wizard.social.activity.WizardSocialActivity
import com.decouikit.atom.components.wizard.walkthrough.activity.WizardWalkThroughActivity
import com.decouikit.atom.extensions.openSubMenuActivity
import com.decouikit.atom.menu.adapter.SubMenuAdapter
import com.decouikit.atom.menu.interfaces.OnNavigationItemClickListener
import com.decouikit.atom.menu.model.NavigationItem
import com.decouikit.atom.menu.model.NavigationItemType
import kotlinx.android.synthetic.main.fragment_sub_menu.view.*

class SubMenuFragment : Fragment(), OnNavigationItemClickListener {

    private lateinit var viewLayout: View
    private var items = arrayListOf<NavigationItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        items = arguments?.getParcelableArrayList(NAVIGATION_ITEM_LIST)!!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadView(inflater.inflate(R.layout.fragment_sub_menu, container, false))
        return viewLayout
    }

    private fun loadView(view: View) {
        viewLayout = view

        viewLayout.rvSubMenu.layoutManager = LinearLayoutManager(viewLayout.context)
        viewLayout.rvSubMenu.adapter = SubMenuAdapter(items, this)
    }
    override fun onNavigationItemClick(view: View, item: NavigationItem) {
        when (item.id) {
            NavigationItemType.LIST_EXPANDABLE,
            NavigationItemType.LIST_DRAG_DROP,
            NavigationItemType.LIST_SWIPE_TO_DISMISS-> {
                openSubMenuActivity(item)
            }
            NavigationItemType.LIST_GOOGLE_CARDS_1 -> {
                startActivity(Intent(view.context, StyledCardActivity::class.java))
            }
            NavigationItemType.LIST_GOOGLE_CARDS_2 -> {
                startActivity(Intent(view.context, StyledTwoCardActivity::class.java))
            }
            NavigationItemType.LIST_GOOGLE_CARDS_3 -> {
                startActivity(Intent(view.context, CardFullImageActivity::class.java))
            }
            NavigationItemType.LIST_GOOGLE_CARDS_4 -> {
                startActivity(Intent(view.context, CardFullImageAvatarActivity::class.java))
            }
            NavigationItemType.LIST_GOOGLE_CARDS_5 -> {
                startActivity(Intent(view.context, ShoppingCartActivity::class.java))
            }
            NavigationItemType.LIST_GOOGLE_CARDS_6 -> {
                startActivity(Intent(view.context, CardCategoryActivity::class.java))
            }
            NavigationItemType.LIST_GOOGLE_CARDS_7 -> {
                startActivity(Intent(view.context, CardImageActivity::class.java))
            }
            NavigationItemType.LIST_GOOGLE_CARDS_8 -> {
                startActivity(Intent(view.context, CardColorActivity::class.java))
            }
            NavigationItemType.LIST_GOOGLE_CARDS_9 -> {
                startActivity(Intent(view.context, SocialThumbActivity::class.java))
            }
            NavigationItemType.LIST_GOOGLE_CARDS_10 -> {
                startActivity(Intent(view.context, ThumbActivity::class.java))
            }
            NavigationItemType.IMAGE_GALLERY_CATEGORIES -> {
                startActivity(Intent(view.context, ImageGalleryCategoryActivity::class.java))
            }
            NavigationItemType.WIZARD_WALK_THROUGH -> {
                startActivity(Intent(view.context, WizardWalkThroughActivity::class.java))
            }
            NavigationItemType.WIZARD_E_COMMERCE -> {
                startActivity(Intent(view.context, WizardECommerceActivity::class.java))
            }
            NavigationItemType.WIZARD_SOCIAL -> {
                startActivity(Intent(view.context, WizardSocialActivity::class.java))
            }
            NavigationItemType.WIZARD_PROFILES -> {
                startActivity(Intent(view.context, WizardProfileActivity::class.java))
            }
            NavigationItemType.TAB_BOTTOM_ICONS -> {
                startActivity(Intent(view.context, NavBottomIconActivity::class.java))
            }
            NavigationItemType.TAB_TOP_ICONS -> {
                startActivity(Intent(view.context, NavTopIconActivity::class.java))
            }
            NavigationItemType.TAB_BOTTOM_TEXT -> {
                startActivity(Intent(view.context, NavBottomTextActivity::class.java))
            }
            NavigationItemType.TAB_TOP_TEXT -> {
                startActivity(Intent(view.context, NavTopTextActivity::class.java))
            }
            NavigationItemType.SEARCH_SIMPLE -> {
                startActivity(Intent(view.context, SearchSimpleActivity::class.java))
            }
            NavigationItemType.SEARCH_TOP_BAR -> {
                startActivity(Intent(view.context, SearchTopBarActivity::class.java))
            }
            NavigationItemType.PARALLAX_FRIENDS -> {
                startActivity(Intent(view.context, FriendsActivity::class.java))
            }
            NavigationItemType.PARALLAX_SHOPPING -> {
                startActivity(Intent(view.context, ShoppingActivity::class.java))
            }
            NavigationItemType.PARALLAX_PROFILE -> {
                startActivity(Intent(view.context, ProfileActivity::class.java))
            }
            NavigationItemType.LOGIN_LOGO_1 -> {
                startActivity(Intent(view.context, LoginActivity::class.java))
            }
            NavigationItemType.REGISTER_LOGO_1 -> {
                startActivity(Intent(view.context, RegisterActivity::class.java))
            }
            NavigationItemType.FORGOT_PASSWORD_SIMPLE -> {
                startActivity(Intent(view.context, ForgotPassActivity::class.java))
            }
            NavigationItemType.OLD_NEW_PASS_WITH_BG -> {
                startActivity(Intent(view.context, NewPassActivity::class.java))
            }
            NavigationItemType.CHECKBOX_SIMPLE_LEFT -> {
                startActivity(Intent(view.context, CheckboxSimpleLeftActivity::class.java))
            }
            NavigationItemType.CHECKBOX_SIMPLE_RIGHT -> {
                startActivity(Intent(view.context, CheckboxSimpleRightActivity::class.java))
            }
            NavigationItemType.CHECKBOX_AVATAR_LEFT -> {
                startActivity(Intent(view.context, CheckboxAvatarLeftActivity::class.java))
            }
            NavigationItemType.CHECKBOX_AVATAR_RIGHT -> {
                startActivity(Intent(view.context, CheckboxAvatarRightActivity::class.java))
            }
            NavigationItemType.CHECKBOX_ICON_LEFT -> {
                startActivity(Intent(view.context, CheckboxIconLeftActivity::class.java))
            }
            NavigationItemType.CHECKBOX_ICON_RIGHT -> {
                startActivity(Intent(view.context, CheckboxIconRightActivity::class.java))
            }
            NavigationItemType.RADIO_BUTTON_SIMPLE_LEFT -> {
                startActivity(Intent(view.context, RadioButtonSimpleLeftActivity::class.java))
            }
            NavigationItemType.RADIO_BUTTON_SIMPLE_RIGHT -> {
                startActivity(Intent(view.context, RadioButtonSimpleRightActivity::class.java))
            }
            NavigationItemType.RADIO_BUTTON_AVATAR_LEFT -> {
                startActivity(Intent(view.context, RadioButtonAvatarLeftActivity::class.java))
            }
            NavigationItemType.RADIO_BUTTON_AVATAR_RIGHT -> {
                startActivity(Intent(view.context, RadioButtonAvatarRightActivity::class.java))
            }
            NavigationItemType.RADIO_BUTTON_ICON_LEFT -> {
                startActivity(Intent(view.context, RadioButtonIconLeftActivity::class.java))
            }
            NavigationItemType.RADIO_BUTTON_ICON_RIGHT -> {
                startActivity(Intent(view.context, RadioButtonIconRightActivity::class.java))
            }
            NavigationItemType.TOGGLE_SIMPLE -> {
                startActivity(Intent(view.context, ToggleSimpleActivity::class.java))
            }
            NavigationItemType.TOGGLE_DESC -> {
                startActivity(Intent(view.context, ToggleDescActivity::class.java))
            }
            NavigationItemType.TOGGLE_GROUP -> {
                startActivity(Intent(view.context, ToggleGroupActivity::class.java))
            }
            NavigationItemType.SMALL_COMPONENTS_ALL -> {
                startActivity(Intent(view.context, SmallComponentsActivity::class.java))
            }
            NavigationItemType.RTL_COLOR_CHANGE_TEST -> {
                startActivity(Intent(view.context, RtlColorChangeActivity::class.java))
            }
            NavigationItemType.SPLASH_SCREEN_SIMPLE -> {
                startActivity(Intent(view.context, SplashSimpleActivity::class.java))
            }
            NavigationItemType.RANGE_ALL -> {
                startActivity(Intent(view.context, RangeActivity::class.java))
            }
            NavigationItemType.SINGLE_SELECT -> {
                startActivity(Intent(view.context, SingleSelectActivity::class.java))
            }
            NavigationItemType.MULTI_SELECT -> {
                startActivity(Intent(view.context, MultiSelectActivity::class.java))
            }
            NavigationItemType.TIMELINE_LEFT -> {
                startActivity(Intent(view.context, TimelineLeftActivity::class.java))
            }
            NavigationItemType.TIMELINE_RIGHT -> {
                startActivity(Intent(view.context, TimelineRightActivity::class.java))
            }
            NavigationItemType.TIMELINE_CENTER -> {
                startActivity(Intent(view.context, TimelineCenterActivity::class.java))
            }
        }
    }

    companion object {
        private const val NAVIGATION_ITEM_LIST = "NAVIGATION_ITEM_LIST"
        fun newInstance(items: ArrayList<NavigationItem>): SubMenuFragment {
            val fragment = SubMenuFragment()
            val args = Bundle()
            args.putParcelableArrayList(NAVIGATION_ITEM_LIST, items)
            fragment.arguments = args
            return fragment
        }
    }
}