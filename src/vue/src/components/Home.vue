<template>
    <div>
<!--        로그인 모달창-->
        <div id="top">
            <v-row justify="center">
                <v-dialog v-model="dialog_login" persistent max-width="600px">
                    <template v-slot:activator="{ on, attrs }">
                        <v-btn
                                color="primary"
                                dark
                                v-bind="attrs"
                                v-on="on"
                        >
                            로그인
                        </v-btn>
                    </template>
                    <v-card>
                        <v-card-title primary-title class="justify-center">
                            <span class="headline">로그인</span>
                        </v-card-title>
                        <v-card-text>
                            <v-container>
                                <v-row>
                                    <v-col cols="12">
                                        <v-text-field label="ID" required ></v-text-field>
                                    </v-col>
<!--                                    <v-col cols="12" >-->
<!--                                        <v-text-field label="Name" required></v-text-field>-->
<!--                                    </v-col>-->
                                    <v-col cols="12">
                                        <v-text-field label="Password"  type="password" required></v-text-field>
                                    </v-col>

                                </v-row>
                            </v-container>
<!--                        회원가입 모달창-->
                        </v-card-text>
                        <v-card-actions>
                            <v-btn left color="blue darken-1" text @click="dialog_signup = !dialog_signup">Signup</v-btn>
                            <v-spacer></v-spacer>
                            <v-btn color="blue darken-1" text @click="login">Login</v-btn>
                            <v-btn right color="blue darken-1" text @click="dialog_login = false">Close</v-btn>

                        </v-card-actions>
                    </v-card>
                    <v-dialog v-model="dialog_signup" persistent max-width="600px">
                    <v-card>
                        <v-card-title primary-title class="justify-center">
                            <span class="headline">회원가입</span>
                        </v-card-title>
                        <v-card-text>
                            <v-form
                                    persistent
                                    ref="form"
                            >
                            <v-container>
                                <v-row>
                                    <v-col cols="12">
                                        <v-text-field label="ID" v-model="id" :rules="idRules" required></v-text-field>
                                    </v-col>
                                    <v-col cols="12" >
                                        <v-text-field label="Name" v-model="name" :rules="nameRules" required></v-text-field>
                                    </v-col>
                                    <v-col cols="12">
                                        <v-text-field label="Password" v-model="password" :rules="passwordRules" type="password" required></v-text-field>
                                    </v-col>

                                </v-row>
                            </v-container>
                            </v-form>
                        </v-card-text>
                        <v-card-actions>
                            <v-spacer></v-spacer>
                            <v-btn color="blue darken-1" text @click="submit">Save</v-btn>
                            <v-btn right color="blue darken-1" text @click="dialog_signup = false">Close</v-btn>

                        </v-card-actions>
                    </v-card>
                    </v-dialog>
                </v-dialog>
            </v-row>


        </div>
        <br />
        <div>
            <img
                    id="google"
                    src="https://www.google.co.kr/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png"
                    title="Google"
            />
        </div>
        <div>
            <input
                    id="search"
                    v-model="searchWord"
                    type="text"
                    style=" background-repeat: no-repeat; background-position: 88% 50%, 98% 50%;"
                    title="검색"
            />
        </div>
        <div id="box">
            <input
                    @click="search"
                    id="google_search"
                    type="button"
                    value="Google 검색"
            />
        </div>
        <div>
            <h3>검색된 수: {{ count }}</h3>
        </div>
        <div id="bottom">
            <div id="bottom_left">
                <a>광고</a>
                <a>비즈니스</a>
                <a>Google 정보</a>
            </div>
            <div id="bottom_right">
                <a>개인정보처리방침</a>
                <a>약관</a>
                <a>설정</a>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                dialog : false,
                dialog_login : false,
                dialog_signup : false,
                searchWord : "",
                name : '',
                id : '',
                password : '',
                idRules : [
                    v => !!v || 'id is required',
                    v => /^[a-zA-Z0-9]{2,24}$/.test(v) || 'id is invalid'
                ],
                nameRules : [
                    v => !!v || 'name is required',
                    v => /^[a-zA-Z0-9]{2,24}$/.test(v) || 'name is invalid'
                ],
                passwordRules: [
                    v => !!v || 'password is required',
                    v => /^[a-zA-Z0-9]{2,24}$/.test(v) ||
                        'password is invalid'
                ],
                count : 0
            }
        },
        methods: {
            search() {
                this.$store.dispatch("crawling/search", this.searchWord)
            },
            // dialog_login() {
            //
            // },
            submit() {
                if (!this.$refs.form.validate()) return;
                alert(`id: ${this.id}, name: ${this.name}, password: ${this.password}`);
                let params = new URLSearchParams()
                alert('초기값: '+params)
                params.append('total', 'total')
                params.append('id', this.id)
                params.append('name', this.name)
                params.append('password', this.password)
                alert("값확인: "+ this.id)
                this.$store.dispatch('member/signup',params)
                this.reset();

            },
            reset() {
                // form 리셋
                this.$refs.form.reset();
                // dialog 비활성화
                this.dialog_signup = false;
            },
            login() {
                let user = new URLSearchParams()
                user.append('total', 'total')
                user.append('id', this.id)
                user.append('password', this.password)
                alert('로그인')
              this.$store.dispatch('member/login',user)
            }
        }
    }
</script>

<style scoped>
    body {
        margin: 0px;
        min-width: 1050px;
        min-height: 550px;
    }
    #top {
        margin: 5px 5px;
        float: right;
    }
    a {
        text-decoration: none;
        font-size: 10.5pt;
        margin: 0px 10px;
        color: grey;
    }
    a:hover {
        text-decoration: underline;
    }
    img {
        margin: 10px 7px;
        width: 20px;
        vertical-align: middle;
    }
    #login {
        background-color: #4485f3;
        color: #ffffff;
        width: 70px;
        height: 30px;
        border: none;
        vertical-align: middle;
        margin: 10px 12px 10px 7px;
        font-weight: bold;
        font-size: 10pt;
        border-radius: 2px;
    }
    #google {
        display: block;
        width: 290px;
        height: 100px;
        margin: 180px auto 20px;
    }
    #search {
        display: block;
        margin: 0 auto;
        width: 550px;
        height: 50px;
        font-size: 15pt;
        box-shadow: 3px 3px 5px #c3c3c3;
        border: 1px solid #eaeaea;
    }
    #box {
        text-align: center;
    }
    #google_search {
        width: 135px;
        height: 40px;
        margin: 30px 3px;
        border: none;
        background-color: #f4f4f4;
        font-weight: bold;
        color: grey;
    }
    #Feeling_Lucky {
        width: 180px;
        height: 40px;
        margin: 30px 3px;
        border: none;
        background-color: #f4f4f4;
        font-weight: bold;
        color: grey;
    }
    #google_search:hover,
    #Feeling_Lucky:hover {
        border: 1px solid #c6c6c6;
        color: black;
    }
    #bottom {
        border: 1px solid #e4e4e4;
        border-right: none;
        border-left: none;
        position: absolute;
        bottom: 0px;
        background-color: #f2f2f2;
        height: 50px;
        width: 100%;
        min-width: 1050px;
    }
    #bottom_left {
        float: left;
        padding: 15px;
    }
    #bottom_right {
        float: right;
        padding: 15px;
    }
</style>