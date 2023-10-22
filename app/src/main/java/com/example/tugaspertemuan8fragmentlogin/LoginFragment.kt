package com.example.tugaspertemuan8fragmentlogin

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.tugaspertemuan8fragmentlogin.MainActivity.Companion.password
import com.example.tugaspertemuan8fragmentlogin.MainActivity.Companion.username
import com.example.tugaspertemuan8fragmentlogin.MainActivity.Companion.viewPagerCompanion


class LoginFragment : Fragment() {
    // Variabel untuk menyimpan referensi ke elemen-elemen UI
    private var textInputUsername: EditText? = null
    private var textInputPassword: EditText? = null
    private var loginButton: View? = null
    private var registerLink: TextView? = null
    private var forgetPasswordLink: TextView? = null

    // Metode yang dipanggil saat fragment ini dibuat
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Menginflasi tata letak (layout) fragment_login.xml ke dalam objek View
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        // Menghubungkan variabel dengan elemen-elemen UI menggunakan ID-nya
        textInputUsername = view.findViewById(R.id.ETUsername)
        textInputPassword = view.findViewById(R.id.ETPassword)
        loginButton = view.findViewById(R.id.btnLogin)
        registerLink = view.findViewById(R.id.linkregister)
        forgetPasswordLink = view.findViewById(R.id.linkforget) // Sesuaikan dengan ID yang sebenarnya di XML

        // Menetapkan tindakan saat tombol login ditekan
        loginButton?.setOnClickListener {
            // Memeriksa apakah kolom username atau password kosong
            if (textInputUsername?.text.toString().isEmpty()) {
                Toast.makeText(context, "Mohon masukkan username", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (textInputPassword?.text.toString().isEmpty()) {
                Toast.makeText(context, "Mohon masukkan password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validasi username dan password
            if (textInputUsername?.text.toString() != username || textInputPassword?.text.toString() != password) {
                Toast.makeText(context, "Username atau Password Salah", Toast.LENGTH_SHORT).show()
            } else {
                // Jika username dan password valid, pindah ke DashboardActivity
                val intentToDashboardActivity = Intent(activity, DashboardActivity::class.java)
                startActivity(intentToDashboardActivity)
            }
        }

        // Menetapkan tindakan saat teks "registerLink" ditekan
        registerLink?.setOnClickListener {
            // Mengganti tampilan ke halaman register dengan mengubah item ViewPager
            viewPagerCompanion.currentItem = 0
        }

        // Menetapkan tindakan saat teks "forgetPasswordLink" ditekan
        forgetPasswordLink?.setOnClickListener {
            // Menampilkan pesan toast jika pengguna lupa password
            Toast.makeText(context, "Kok bisa bang? Coba inget lagi", Toast.LENGTH_LONG).show()
        }

        // Mengembalikan objek View yang telah diatur
        return view
    }
}
