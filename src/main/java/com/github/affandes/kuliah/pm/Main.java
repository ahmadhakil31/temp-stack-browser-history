package com.github.affandes.kuliah.pm;

 class TextEditor:
    def __init__(self):
        self.text = ""
        self.undo_stack = []
        self.redo_stack = []

    def write(self, new_text):
        # Simpan keadaan sebelum perubahan
        self.undo_stack.append(self.text)

        # Tambahkan teks baru
        self.text += new_text

        # Setelah write, redo stack harus dihapus
        self.redo_stack.clear()

        print(f"Menulis: '{new_text}'")

    def undo(self):
        if not self.undo_stack:
            print("Tidak ada aksi yang bisa di-undo!")
            return

        # Simpan kondisi sekarang ke redo stack
        self.redo_stack.append(self.text)

        # Kembali ke kondisi sebelumnya
        self.text = self.undo_stack.pop()

        print("Undo berhasil.")

    def redo(self):
        if not self.redo_stack:
            print("Tidak ada aksi yang bisa di-redo!")
            return

        # Simpan kondisi sekarang ke undo stack
        self.undo_stack.append(self.text)

        # Pulihkan teks yang pernah di-undo
        self.text = self.redo_stack.pop()

        print("Redo berhasil.")

    def show(self):
        print("\n=== ISI TEXT EDITOR ===")
        print(self.text)
        print("=======================\n")


def main():
    editor = TextEditor()
    print("=== TEXT EDITOR SIMULATOR ===")
    print("Perintah yang tersedia:")
    print("write <teks>, undo, redo, show, exit")

    while True:
        command = input(">>> ").strip()

        if command.startswith("write "):
            teks = command[6:]
            editor.write(teks)

        elif command == "undo":
            editor.undo()

        elif command == "redo":
            editor.redo()

        elif command == "show":
            editor.show()

        elif command == "exit":
            print("Keluar dari program...")
            break

        else:
            print("Perintah tidak dikenal.")


if __name__ == "__main__":
    main()
