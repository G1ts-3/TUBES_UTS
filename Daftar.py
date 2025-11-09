from tkinter import *
from tkinter import messagebox
import ast

window=Tk()
window.title("Daftar")
window.geometry('270x450')
window.configure(bg="#fff")
window.resizable(False,False)

def signup():
    username=user.get()
    password=code.get()
    confirm_password=confirm_code.get()

    if password==confirm_password:
        try:
            file=open('datasheet.txt','r+')
            d=file.read()
            r=ast.literal_eval(d)

            dict2={username:password}
            r.update(dict2)
            file.truncate(0)
            file.close()

            file=open('datasheet.txt','w')
            w=file.write(str(r))

            messagebox.showinfo('Signup',"Sucessfully Sign Up")
            window.destroy()
            import kasir


        except:
            file=open('datasheet.txt','w')
            pp=str({'Username':'Password'})
            file.write(pp)
            file.close
    else:
        messagebox.showerror('Invalid',"Both Password Should Match")

def login():
    window.destroy()
    import Login
    

frame=Frame(window,width=270,height=370,bg="white")
frame.place(x=5,y=4)

heading=Label(frame,text='Daftar',fg="black",bg='white',font=('Rockwell',21))
heading.place(x=80,y=25)

#Username
def on_enter(e):
    user.delete(0,'end')

def on_leave(e):
    name=user.get()
    if name=='':
        user.insert(0,'Username')

user = Entry(frame,width=25,fg='black',border=0,bg='white',font=('Rockwell',10))
user.place(x=25,y=115)
user.insert(0,'Username')
user.bind('<FocusIn>',on_enter)
user.bind('<FocusOut>',on_leave)

Frame(frame,width=215,height=2,bg='black').place(x=20,y=135)

#Password
def on_enter(e):
    code.delete(0,'end')

def on_leave(e):
    name=code.get()
    if name=='':
        code.insert(0,'Password')

code = Entry(frame,width=25,fg='black',border=0,bg='white',font=('Rockwell',10))
code.place(x=25,y=180)
code.insert(0,'Password')
code.bind('<FocusIn>',on_enter)
code.bind('<FocusOut>',on_leave)

Frame(frame,width=215,height=2,bg='black').place(x=20,y=200)

#Confirm Password
def on_enter(e):
    confirm_code.delete(0,'end')

def on_leave(e):
    name=confirm_code.get()
    if name=='':
        confirm_code.insert(0,'Confirmasi Password')

confirm_code = Entry(frame,width=25,fg='black',border=0,bg='white',font=('Rockwell',10))
confirm_code.place(x=25,y=240)
confirm_code.insert(0,'Confirmasi Password')
confirm_code.bind('<FocusIn>',on_enter)
confirm_code.bind('<FocusOut>',on_leave)

Frame(frame,width=215,height=2,bg='black').place(x=20,y=260)

#Button
Button(frame,width=20,pady=7,text='Daftar',bg='#494954',fg='white',border=0,command=signup).place(x=45,y=310)
label=Label(frame,text="Memiliki Akun?",fg='black',bg='white',font=('Rockwell',8))
label.place(x=60,y=350)

sign_up= Button(frame,width=4,text='Login',border=0,bg='white',cursor='hand2',fg="#494954",command=login)
sign_up.place(x=141,y=349)

window.mainloop()