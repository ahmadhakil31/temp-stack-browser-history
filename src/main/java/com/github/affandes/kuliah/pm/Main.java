package com.github.affandes.kuliah.pm;

class BrowserHistory:
    def __init__(self):
        self.history = []   # menyimpan daftar website yang pernah dikunjungi

    def browse(self, website):
        """Menambahkan website baru ke history."""
        self.history.append(website)
        print(f"Browsing ke: {website}")

    def view(self):
        """Menampilkan semua history, diurutkan dari yang paling baru."""
        if not self.history:
            print("History kosong.")
            return

        print("\n=== HISTORY BROWSER (TERBARU DI ATAS) ===")
        for i, site in enumerate(reversed(self.history), 1):
            print(f"{i}. {site}")
        print("========================================\n")

    def back(self):
        """Kembali ke website sebelumnya dengan menghapus history terakhir."""
        if len(self.history) <= 1:
            print("Tidak bisa kembali, history terlalu sedikit!")
            return

        last_site = self.history.pop()
        print(f"Kembali dari '{last_site}' ke '{self.history[-1]}'")


def main():
    browser = BrowserHistory()
    print("=== SIMULASI HISTORY BROWSER ===")
    print("Perintah: browse <url>, view, back, exit")
    
    while True:
        command = input(">>> ").strip()

        if command.startswith("browse "):
            url = command[7:]  # ambil teks setelah "browse "
            browser.browse(url)

        elif command == "view":
            browser.view()

        elif command == "back":
            browser.back()

        elif command == "exit":
            print("Keluar dari program...")
            break
        
        else:
            print("Perintah tidak dikenal!")


if __name__ == "__main__":
    main()
