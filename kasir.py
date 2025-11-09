import tkinter
from tkinter import*
from tkinter import messagebox


root = Tk()
root.title("Kasir NyamNyam..")
root.geometry("700x350+200+100")
root.resizable(0,0)
root.config(bg='#faf38e')

#nama kasir
nama_kasir= Label(text='𝕂𝕒𝕤𝕚𝕣 ℕ𝕪𝕒𝕞ℕ𝕪𝕒𝕞',font=('Rockwell',18,'bold'))
nama_kasir.place(x=230,y=10)

#makanan label
makanan_label= Label(text='Pilih Makanan',font=('Rockwell',10))
makanan_label.place(x=25,y=65)

#######################################
def cek():
    nasgor_total= int(nasgor_sb.get()) * 12000
    mie_total=int(mie_sb.get()) * 10000
    goreng_total=int(goreng_sb.get()) * 1000
    esteh_total=int(esteh_sb.get()) * 5000
    esjeruk_total=int(esjeruk_sb.get()) * 6000

    total= nasgor_total +mie_total +goreng_total +esteh_total + esjeruk_total
    total_label = Label(text=f'Rp.{total}',font=('Rockwell',9))
    total_label.place(x=110,y=290)
    return total


########################################
#Kolom Pembayaran
def on_enter(e):
    uangmu.delete(0,'end')
def on_leave(e):
    name=uangmu.get()
    if name=='':
        uangmu.insert(0,0)

uangmu_variable = StringVar()
uangmu=Entry(root,width=20,fg='black',border=1,bg='white',font=('Rockwell',9), textvariable= uangmu_variable)
uangmu.place(x=350,y=290)
uangmu.insert(0,'Masukkan Uang Anda..')
uangmu.bind('<FocusIn>',on_enter)
uangmu.bind('<FocusOut>',on_leave)
###########################################

def kembalian ():
    global uangmu_variable
    total = cek()
    uang = int(uangmu_variable.get())
    
    if uang >= total:
        kembalian = (uang - total)
        messagebox.showinfo(message=('Kembalianmu Sebesar',kembalian))
        messagebox.showinfo(message=('Terima kasih telah Berbelanja😁..'))
        root.destroy()


    elif uang<=total:
        messagebox.showerror(message='Maaf Uangmu Kurang..')


def Logout():
    answer=messagebox.askquestion('Logout','Anda Yakin Ingin Keluar?')
    if answer == 'yes':
        root.destroy()
        import Login

        
#label nasgor
nasgor_label= Label(text='Nasi Goreng',font=('italic',9,'normal'))
nasgor_label.place(x=65,y=115)
nasgor_harga= Label(text='Rp 12.000',font=('italic',9,'normal')).place(x=175,y=115)
nasgor_sb= Spinbox(from_=0,to=100,width=5)
nasgor_sb.place(x=255,y=115)

#label mie
mie_label= Label(text='Mie',font=('italic',9,'normal'))
mie_label.place(x=65,y=155)
mie_harga= Label(text='Rp 10.000',font=('italic',9,'normal')).place(x=175,y=155)
mie_sb= Spinbox(from_=0,to=100,width=5)
mie_sb.place(x=255,y=155)


#label mie
goreng_label= Label(text='Gorengan',font=('italic',9,'normal'))
goreng_label.place(x=65,y=195)
goreng_harga= Label(text='Rp 1.000',font=('italic',9,'normal')).place(x=175,y=195)
goreng_sb= Spinbox(from_=0,to=100,width=5)
goreng_sb.place(x=255,y=195)


#minuman label
minuman_label= Label(text='Pilih Minuman',font=('Rockwell',10))
minuman_label.place(x=405,y=65)

#label esteh
esteh_label= Label(text='Es Teh',font=('italic',9,'normal'))
esteh_label.place(x=455,y=115)
esteh_harga= Label(text='Rp 5.000',font=('italic',9,'normal')).place(x=545,y=115)
esteh_sb= Spinbox(from_=0,to=100,width=5)
esteh_sb.place(x=620,y=115)

#label esJeruk
esjeruk_label= Label(text='Es Jeruk',font=('italic',9,'normal'))
esjeruk_label.place(x=455,y=155)
esjeruk_harga= Label(text='Rp 6.000',font=('italic',9,'normal')).place(x=545,y=155)
esjeruk_sb= Spinbox(from_=0,to=100,width=5)
esjeruk_sb.place(x=620,y=155)

Label(text='Total :',font=('Rockwell',9)).place(x=60,y=290)
total_button=Button(text= "Cek Harga",command= cek,bg='#828780')
total_button.place(x=60,y=250)

bayar=Button(text='Bayar Yuk',command= kembalian,bg='#7efc65').place(x=350,y=250)




root.mainloop()