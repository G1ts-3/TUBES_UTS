from tkinter import*
from tkinter import messagebox

root=Tk()
root.title("Login Kasir")
root.geometry('300x400+250+200')
root.configure(bg='#fff')
root.resizable(0,0)

def Daftar():
    root.destroy()
    import Daftar
    

def login():
    username=user.get()
    password=pw.get()

    if username=='abc' and password=='123':
        messagebox.showinfo('Berhasil','Login Berhasil')
        root.destroy()
        import kasir
    else:
        messagebox.showerror('Invalid','Username dan Password salah')

frame=Frame(root, width=200,height=350,bg='white')
frame.place(x=40,y=40)

heading=Label(frame,text='Login',fg='#494954',bg='white',font=('Rockwell',19,'bold'))
heading.place(x=65,y=2)
#######################################
#kotak usename
def on_enter(e):
    user.delete(0,'end')
def on_leave(e):
    name=user.get()
    if name=='':
        user.insert(0,"Username")

user=Entry(frame,width=20,fg='black',border=0,bg='white',font=('Rockwell',12))
user.place(x=19,y=95)
user.insert(0,'Username')
user.bind('<FocusIn>',on_enter)
user.bind('<FocusOut>',on_leave)

Frame(frame,width=200,height=2,bg='black').place(x=14,y=120)

#######################################
#kotak password
def on_enter(e):
    pw.delete(0,'end')
def on_leave(e):
    name=pw.get()
    if name=='':
        pw.insert(0,"Password")
pw=Entry(frame,width=20,fg='black',border=0,bg='white',font=('Rockwell',12))
pw.place(x=19,y=170)
pw.insert(0,'Password')
pw.bind('<FocusIn>',on_enter)
pw.bind('<FocusOut>',on_leave)

Frame(frame,width=200,height=2,bg='black').place(x=14,y=195)

#######################################\
#tombol login
Button(frame,width=20,pady=5,text='Login',bg='#494954',fg='white',border=0,command=login).place(x=25,y=250)

hmm=Label(frame,text='©Copyright_Raghid',fg='#494954',bg='white',font=('Rockwell',7,'bold'))
hmm.place(x=50,y=295)

root.mainloop()