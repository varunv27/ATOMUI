package com.decouikit.atom.components.login.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.util.SharedPrefs
import kotlinx.android.synthetic.main.fragment_login.view.*

class LoginFragment : Fragment(), View.OnClickListener {

    private lateinit var viewLayout: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadView(inflater.inflate(R.layout.fragment_login, container, false))
        return this.viewLayout
    }

    private fun loadView(view: View) {
        viewLayout = view
        if (SharedPrefs(requireContext()).isRtlEnabled) {
            viewLayout.ivBack.rotation = 180f
        }
        initListeners()
    }

    private fun initListeners() {
        viewLayout.btnFacebook.setOnClickListener(this)
        viewLayout.btnTwitter.setOnClickListener(this)
        viewLayout.btnLogin.setOnClickListener(this)
        viewLayout.tvLoginButton1.setOnClickListener(this)
        viewLayout.tvLoginButton2.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            viewLayout.btnFacebook -> {
                Toast.makeText(viewLayout.context, R.string.facebook, Toast.LENGTH_SHORT).show()
            }
            viewLayout.btnTwitter -> {
                Toast.makeText(viewLayout.context, R.string.twitter, Toast.LENGTH_SHORT).show()
            }
            viewLayout.btnLogin -> {
                Toast.makeText(viewLayout.context, R.string.login, Toast.LENGTH_SHORT).show()
            }
            viewLayout.tvLoginButton1 -> {
                Toast.makeText(viewLayout.context, R.string.sign_up, Toast.LENGTH_SHORT).show()
            }
            viewLayout.tvLoginButton2 -> {
                Toast.makeText(viewLayout.context, R.string.get_new, Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        fun newInstance(): LoginFragment {
            return LoginFragment()
        }
    }
}