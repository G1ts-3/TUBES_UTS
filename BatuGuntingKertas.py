import random

def menang():
    print(f"\"{jb_pemain}\" lawan \"{jb_komputer}\": \n\"Selamat kamu menang!!\"")

def kalah():
    print(f"\"{jb_pemain}\" lawan \"{jb_komputer}\": \n\"Yah kamu kalah TwT\"")


print("=======================================")
print("By : Raghid Muhammad")
print("X TEL 13")
print("=======================================")
print("       BATU - GUNTING - KERTAS")
print("=======================================")
print("SELAMAT DATANG DI BATU GUNTING KERTAS")
print("""  Peraturan Bermain:\n-Pilih batu/gunting/kertas.
-Lalu jawaban akan diproses oleh program.
-Setelah itu kamu bisa melihat hasilnya.

*Semua jawaban dan tanggapan menggunakan huruf kecil
========================================""")


awalmain = str(input("Mulai Bermain?\n(iya/tidak): "))
if awalmain.lower() == "tidak":
    quit()


while True:

    print("=======================================")
    komputer = ["kertas","gunting","batu"]
    jb_komputer = (random.choice(komputer))
    
    jb_pemain = str(input("Masukan Pilihanmu\n(batu/gunting/kertas): "))
    
    if jb_pemain in "batu" or "kertas" or "gunting":

        print("=======================================")
        print(f"Komputer memilih  :\"{jb_komputer}\" \nKamu memilih      :\"{jb_pemain}\" ")
        print("=======================================")
    
        
        if jb_pemain == jb_komputer:
            print(f"\"{jb_pemain}\" lawan \"{jb_komputer}\":\n\"Wah, Kita Seri!!\" ")

        elif jb_pemain.lower() == "batu": 
            if jb_komputer == "gunting":
                menang()

            else: 
                kalah()

        elif jb_pemain.lower() == "gunting":
            if jb_komputer == "kertas":
                menang()

            else: 
                kalah()

        elif jb_pemain.lower() == "kertas":
            if jb_komputer == "batu":
                menang()

            else: 
                kalah()

        else:
            print("Invalid Code")

        print("=======================================")

        gameover = str(input("Main lagi?\n(iya/tidak): "))
        if gameover == "tidak":
            break
           
    else:
        print("=======================================")
        print("Invalid Code")            










