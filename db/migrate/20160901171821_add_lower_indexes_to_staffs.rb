class AddLowerIndexesToStaffs < ActiveRecord::Migration[5.0]
  def up
    execute %{
      CREATE INDEX 
        staffs_lower_last_name 
      ON 
        staffs (lower(last_name) varchar_pattern_ops)
    }
    execute %{
      CREATE INDEX 
        staffs_lower_first_name
      ON 
        staffs (lower(first_name) varchar_pattern_ops)
    }
    execute %{
      CREATE INDEX 
        staffs_lower_email 
      ON 
        staffs (lower(email))
    }
  end
  def down
    remove_index :staffs, name: 'staffs_lower_last_name'
    remove_index :staffs, name: 'staffs_lower_first_name'
    remove_index :staffs, name: 'staffs_lower_email'
  end
end
