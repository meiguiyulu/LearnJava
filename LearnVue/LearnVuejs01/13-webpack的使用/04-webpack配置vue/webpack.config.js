const path = require('path')
// webpack.config.js
const { VueLoaderPlugin } = require('vue-loader')

module.exports = {
    /*处理Js文件*/
    entry: './src/main.js',/*入口*/
    output: {
        path: path.resolve(__dirname, 'dist'),/*路径  这里只能填绝对路径*/
        filename: 'bundle.js', /*文件名*/
        publicPath: 'dist/', /*配置上这个以后涉及到url的操作会自动把这个路径添加进去*/
    },/*出口*/
    /*处理CSS文件*/
    module: {
        rules: [
            {
                test: /\.css$/i,
                /*css-loader只负责加载css文件
                style-loader负责将样式添加到DOM中
                使用多个loader的时候 读取顺序：从右向左
                * */
                use: ["style-loader", "css-loader"],
            },
            {
                test: /\.less$/i,
                use: [
                    {
                        loader: 'style-loader',
                    },
                    {
                        loader: 'css-loader',
                    },
                    {
                        loader: 'less-loader',
                    },
                ],
            },
            // {
            //     test: /\.(png|jpg|gif)$/i,
            //     use: [
            //         {
            //             loader: 'url-loader',
            //             options: {
            //                 limit: 8192
            //             }
            //         }
            //     ]
            // },
            {
                test: /\.(png|jpg|gif)$/,
                use: [
                    {
                        loader: 'file-loader',

                        options: {
                            name: 'img/[name].[hash:8].[ext]' /*文件的路径已经名字*/
                        },
                        // mode: 'development',
                    },
                ],
            },
            {
                test: /\.vue$/,
                use: ['vue-loader'],
            }
        ],
    },
    /*指明vue使用runtime-compile版本*/
    resolve: {
        alias: {
            'vue$': 'vue/dist/vue.esm.js',
        }
    }
}