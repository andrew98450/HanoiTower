using System;
using System.Collections;
using System.Windows.Forms;

namespace HanoiTower
{
    public partial class Level3Form : Form
    {
        const int limit_count = 60;
        const int tower_count = 5;
        int count = 1;
        bool is_push = false;
        string[] tower = { "=", "===", "=====", "=======", "=========" };
        string pole = "|";
        int tmp_tower = 0;
        int tmp_count = 0;
        int tmp_move = 0;
        Stack pole1_status = new Stack();
        Stack pole2_status = new Stack();
        Stack pole3_status = new Stack();
        object[] tmp_arr;
        int[] tower_arr = { 5, 4, 3, 2, 1 };
        public Level3Form()
        {
            InitializeComponent();
        }
        public void Init()
        {
            pole1_status.Clear();
            pole2_status.Clear();
            pole3_status.Clear();
            textBox1.Text = "";
            textBox2.Text = "";
            textBox3.Text = "";
            count = 1;
            checkBox1.Checked = false;
            is_push = false;
            label1.Text = "搬移次數:";
            label2.Text = "限制搬移次數:";
            button3.Text = "Pop";
            button4.Text = "Push";
            button5.Text = "Push";
            button3.Enabled = true;
            button4.Enabled = false;
            button5.Enabled = false;
            for (int i = 0; i < tower.Length; i++)
            {
                textBox1.Text += tower[i] + "\r\n";
            }
            for (int i = 0; i < tower.Length; i++)
            {
                pole1_status.Push(tower_arr[i]);
            }
            for (int i = 1; i <= 4; i++)
            {
                textBox2.Text += pole + "\r\n";
                textBox3.Text += pole + "\r\n";
            }
        }
        public void Pop(int move_pole)
        {
            switch (move_pole)
            {
                case 1:
                    if (pole1_status.Count != 0)
                    {
                        tmp_tower = Convert.ToInt32(pole1_status.Pop());
                        tmp_count = tower_count - pole1_status.Count;
                        tmp_arr = pole1_status.ToArray();
                        string str = "";
                        for (int i = 0; i < tmp_count; i++)
                        {
                            str += pole + "\r\n";
                        }
                        for (int i = 0; i < tmp_arr.Length; i++)
                        {
                            str += tower[Convert.ToInt32(tmp_arr[i]) - 1] + "\r\n";
                        }
                        textBox1.Text = str;
                    }
                    else
                    {
                        MessageBox.Show("搬移失敗:河內塔是空的", "HanoiTower");
                        is_push = false;
                    }
                    break;
                case 2:
                    if (pole2_status.Count != 0)
                    {
                        tmp_tower = Convert.ToInt32(pole2_status.Pop());
                        tmp_count = tower_count - pole2_status.Count;
                        tmp_arr = pole2_status.ToArray();
                        string str = "";
                        for (int i = 0; i < tmp_count; i++)
                        {
                            str += pole + "\r\n";
                        }
                        for (int i = 0; i < tmp_arr.Length; i++)
                        {
                            str += tower[Convert.ToInt32(tmp_arr[i]) - 1] + "\r\n";
                        }
                        textBox2.Text = str;
                    }
                    else
                    {
                        MessageBox.Show("搬移失敗:河內塔是空的", "HanoiTower");
                        is_push = false;
                    }
                    break;
                case 3:
                    if (pole3_status.Count != 0)
                    {
                        tmp_tower = Convert.ToInt32(pole3_status.Pop());
                        tmp_count = tower_count - pole3_status.Count;
                        tmp_arr = pole3_status.ToArray();
                        string str = "";
                        for (int i = 0; i < tmp_count; i++)
                        {
                            str += pole + "\r\n";
                        }
                        for (int i = 0; i < tmp_arr.Length; i++)
                        {
                            str += tower[Convert.ToInt32(tmp_arr[i]) - 1] + "\r\n";
                        }
                        textBox3.Text = str;
                    }
                    else
                    {
                        MessageBox.Show("搬移失敗:河內塔是空的", "HanoiTower");
                        is_push = false;
                    }
                    break;
            }
        }
        public void Push(int to_pole, int move_pole)
        {
            switch (to_pole)
            {
                case 1:
                    if (pole1_status.Count != 0)
                    {
                        if (Convert.ToInt32(pole1_status.Peek()) > tmp_tower)
                        {
                            pole1_status.Push(tmp_tower);
                            tmp_count = tower_count - pole1_status.Count;
                            tmp_arr = pole1_status.ToArray();
                            string str = "";
                            for (int i = 0; i < tmp_count; i++)
                            {
                                str += pole + "\r\n";
                            }
                            for (int i = 0; i < tmp_arr.Length; i++)
                            {
                                str += tower[Convert.ToInt32(tmp_arr[i]) - 1] + "\r\n";
                            }
                            textBox1.Text = str;
                            if (checkBox1.Checked == true)
                            {
                                label1.Text = "搬移次數:" + count++.ToString();
                            }
                        }
                        else
                        {
                            MessageBox.Show("搬移失敗:需要小的河內塔", "HanoiTower");
                            Push(move_pole, to_pole);
                        }
                    }
                    else
                    {
                        pole1_status.Push(tmp_tower);
                        tmp_count = tower_count - pole1_status.Count;
                        tmp_arr = pole1_status.ToArray();
                        string str = "";
                        for (int i = 0; i < tmp_count; i++)
                        {
                            str += pole + "\r\n";
                        }
                        for (int i = 0; i < tmp_arr.Length; i++)
                        {
                            str += tower[Convert.ToInt32(tmp_arr[i]) - 1] + "\r\n";
                        }
                        textBox1.Text = str;
                        if (checkBox1.Checked == true)
                        {
                            label1.Text = "搬移次數:" + count++.ToString();
                        }
                    }
                    break;
                case 2:
                    if (pole2_status.Count != 0)
                    {
                        if (Convert.ToInt32(pole2_status.Peek()) > tmp_tower)
                        {
                            pole2_status.Push(tmp_tower);
                            tmp_count = tower_count - pole2_status.Count;
                            tmp_arr = pole2_status.ToArray();
                            string str = "";
                            for (int i = 0; i < tmp_count; i++)
                            {
                                str += pole + "\r\n";
                            }
                            for (int i = 0; i < tmp_arr.Length; i++)
                            {
                                str += tower[Convert.ToInt32(tmp_arr[i]) - 1] + "\r\n";
                            }
                            textBox2.Text = str;
                            if (checkBox1.Checked == true)
                            {
                                label1.Text = "搬移次數:" + count++.ToString();
                            }
                        }
                        else
                        {
                            MessageBox.Show("搬移失敗:需要小的河內塔", "HanoiTower");
                            Push(move_pole, to_pole);
                        }
                    }
                    else
                    {
                        pole2_status.Push(tmp_tower);
                        tmp_count = tower_count - pole2_status.Count;
                        tmp_arr = pole2_status.ToArray();
                        string str = "";
                        for (int i = 0; i < tmp_count; i++)
                        {
                            str += pole + "\r\n";
                        }
                        for (int i = 0; i < tmp_arr.Length; i++)
                        {
                            str += tower[Convert.ToInt32(tmp_arr[i]) - 1] + "\r\n";
                        }
                        textBox2.Text = str;
                        if (checkBox1.Checked == true)
                        {
                            label1.Text = "搬移次數:" + count++.ToString();
                        }
                    }
                    break;
                case 3:
                    if (pole3_status.Count != 0)
                    {
                        if (Convert.ToInt32(pole3_status.Peek()) > tmp_tower)
                        {
                            pole3_status.Push(tmp_tower);
                            tmp_count = tower_count - pole3_status.Count;
                            tmp_arr = pole3_status.ToArray();
                            string str = "";
                            for (int i = 0; i < tmp_count; i++)
                            {
                                str += pole + "\r\n";
                            }
                            for (int i = 0; i < tmp_arr.Length; i++)
                            {
                                str += tower[Convert.ToInt32(tmp_arr[i]) - 1] + "\r\n";
                            }
                            textBox3.Text = str;
                            if (checkBox1.Checked == true)
                            {
                                label1.Text = "搬移次數:" + count++.ToString();
                            }
                        }
                        else
                        {
                            MessageBox.Show("搬移失敗:需要小的河內塔", "HanoiTower");
                            Push(move_pole, to_pole);
                        }
                    }
                    else
                    {
                        pole3_status.Push(tmp_tower);
                        tmp_count = tower_count - pole3_status.Count;
                        tmp_arr = pole3_status.ToArray();
                        string str = "";
                        for (int i = 0; i < tmp_count; i++)
                        {
                            str += pole + "\r\n";
                        }
                        for (int i = 0; i < tmp_arr.Length; i++)
                        {
                            str += tower[Convert.ToInt32(tmp_arr[i]) - 1] + "\r\n";
                        }
                        textBox3.Text = str;
                        if (checkBox1.Checked == true)
                        {
                            label1.Text = "搬移次數:" + count++.ToString();
                        }
                    }
                    break;
            }
        }
        private void Button1_Click(object sender, EventArgs e)
        {
            MainForm form = new MainForm();
            form.Show();
            Hide();
        }

        private void Level3Form_Load(object sender, EventArgs e)
        {
            Init();
        }

        private void Level3Form_FormClosing(object sender, FormClosingEventArgs e)
        {
            MainForm form = new MainForm();
            form.Show();
            Hide();
        }

        private void CheckBox1_CheckedChanged(object sender, EventArgs e)
        {
            label2.Text = "限制搬移次數:" + limit_count.ToString();
        }

        private void Button2_Click(object sender, EventArgs e)
        {
            Init();
        }

        private void Button3_Click(object sender, EventArgs e)
        {
            button3.Enabled = false;
            button4.Enabled = true;
            button5.Enabled = true;
            button3.Text = "Pop";
            button4.Text = "Push";
            button5.Text = "Push";
            if (is_push == true)
            {
                is_push = false;
                Push(1, tmp_move);
            }
            else
            {
                is_push = true;
                tmp_move = 1;
                Pop(tmp_move);
            }
            if (count > limit_count)
            {
                MessageBox.Show("超過限制次數", "HanoiTower");
                Init();
            }
        }

        private void Button4_Click(object sender, EventArgs e)
        {
            button3.Enabled = true;
            button4.Enabled = false;
            button5.Enabled = true;
            button3.Text = "Push";
            button4.Text = "Pop";
            button5.Text = "Push";
            if (is_push == true)
            {
                is_push = false;
                Push(2, tmp_move);
            }
            else
            {
                is_push = true;
                tmp_move = 2;
                Pop(tmp_move);
            }
            if (count > limit_count)
            {
                MessageBox.Show("超過限制次數", "HanoiTower");
                Init();
            }
        }

        private void Button5_Click(object sender, EventArgs e)
        {
            button3.Enabled = true;
            button4.Enabled = true;
            button5.Enabled = false;
            button3.Text = "Push";
            button4.Text = "Push";
            button5.Text = "Pop";
            if (is_push == true)
            {
                is_push = false;
                Push(3, tmp_move);
                if (pole3_status.Count == tower_count)
                {
                    MessageBox.Show("挑戰成功", "HanoiTower");
                    Init();
                }
            }
            else
            {
                is_push = true;
                tmp_move = 3;
                Pop(tmp_move);
            }
            if (count > limit_count)
            {
                MessageBox.Show("超過限制次數", "HanoiTower");
                Init();
            }
        }
    }
}
